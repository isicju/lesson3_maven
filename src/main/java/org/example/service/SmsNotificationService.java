package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.example.utils.StringValidationUtils.*;

public class SmsNotificationService implements NotificationService {
    private final static String SMS_URL_PROVIDER = "https://gate.smsaero.ru/v2/sms/send";
    private final static int SMS_TEXT_MESSAGE_MIN_LENGTH = 3;

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders securityHeaders;

    public SmsNotificationService(String userName, String password) {
        securityHeaders = buildSecurityHeaders(userName, password);
    }

    @Override
    public void sendMessage(String phone, String text) {
        ObjectMapper objectMapper = new ObjectMapper();
        SmsBody body = new SmsBody(phone, text);
        try {
            objectMapper.writeValue(new File("src/main/java/org/example/jsonsGenerated/smsBodyJson.json"), body);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        HttpEntity<String> request = new HttpEntity<>("src/main/java/org/example/jsonsGenerated/smsBodyJson.json", securityHeaders);
        restTemplate.postForObject(SMS_URL_PROVIDER, request, String.class);
    }

    /* public void sendMessage(String phone, String text) {
        SmsBody body = new SmsBody(phone, text);

        Gson gson = new Gson();
        String validJson = gson.toJson(body);

        HttpEntity<String> request = new HttpEntity<>(validJson, securityHeaders);
        restTemplate.postForObject(SMS_URL_PROVIDER, request, String.class);
    }
    */

    private HttpHeaders buildSecurityHeaders(String userName, String password) {
        return new HttpHeaders() {{
            String auth = userName + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")));
            set("Authorization", "Basic " + new String(encodedAuth));
            set("Content-Type", "application/json");
        }};
    }

    static class SmsBody {
        String number;
        String text;
        String sign = "SMS Aero";

        public SmsBody(String number, String text) {
            if (!hasOnlyDigitsBracketsAndPlus(number)) {
                throw new RuntimeException("phone: " + number + " has invalid format!");
            }
            if (!hasLengthMoreThan(text, SMS_TEXT_MESSAGE_MIN_LENGTH)) {
                throw new RuntimeException("message: " + text + " is too short!");
            }
            if (!numberIsFromCIS(number)) {
                throw new RuntimeException("phone: " + number + " is not from CIS country!");
            }
            this.number = number;
            this.text = text;
        }
    }

}
