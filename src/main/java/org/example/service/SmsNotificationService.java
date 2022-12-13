package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

import static org.example.StringValidationUtils.hasLengthMoreThan;
import static org.example.StringValidationUtils.hasOnlyDigits;
import static org.example.StringValidationUtils.hasCisCode;

public class SmsNotificationService implements NotificationService{
    private final static String SMS_URL_PROVIDER = "https://gate.smsaero.ru/v2/sms/send";
    private final static int SMS_TEXT_MESSAGE_MIN_LENGTH = 3;

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders securityHeaders;

    public SmsNotificationService(String userName, String password) {
        securityHeaders = buildSecurityHeaders(userName, password);
    }

    @Override
    public void sendMessage(String phone, String text) {
        SmsBody body = new SmsBody(phone, text);

//        Gson gson = new Gson();
//        String validJson = gson.toJson(body);

        ObjectMapper mapper = new ObjectMapper();
        String validJson = "";
        try {
            validJson = mapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpEntity<String> request = new HttpEntity<>(validJson, securityHeaders);
        restTemplate.postForObject(SMS_URL_PROVIDER, request, String.class);
    }

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
            String[] formattedNumber = number.split("[+()\\-]");
            StringBuilder sb = new StringBuilder();
            for (String s : formattedNumber) {
                sb.append(s);
            }
            number = sb.toString();
            if (!hasOnlyDigits(number)) {
                throw new RuntimeException("phone: " + number + " has invalid format!");
            }
            if (!hasCisCode(number)) {
                throw new RuntimeException("phone: " + number + " has invalid code!");
            }
            if (!hasLengthMoreThan(text, SMS_TEXT_MESSAGE_MIN_LENGTH)) {
                throw new RuntimeException("message: " + text + " is too short!");
            }
            this.number = number;
            this.text = text;
        }
    }

}
