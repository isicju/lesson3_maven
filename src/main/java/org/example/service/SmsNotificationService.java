package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.StringValidationUtils.hasLengthMoreThan;
import static org.example.StringValidationUtils.hasOnlyDigits;

public class SmsNotificationService implements NotificationService{
    private final static String SMS_URL_PROVIDER = "https://gate.smsaero.ru/v2/sms/send";
    private final static int SMS_TEXT_MESSAGE_MIN_LENGTH = 3;

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders securityHeaders;

    public SmsNotificationService(String userName, String password) {
        securityHeaders = buildSecurityHeaders(userName, password);
    }

    private String ConvertSMSToJson(SmsBody val) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(val);
    }

    @Override
    public void sendMessage(String phone, String text)  {
        SmsBody body = new SmsBody(phone, text);

       /* Gson gson = new Gson();
        String validJson = gson.toJson(body);*/
        ObjectMapper mapper = new ObjectMapper();
        String validJson = null;
        try {
            validJson = ConvertSMSToJson(body);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
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

        private static final Pattern VALID_SNG =
                Pattern.compile("^(\\+7|\\+994|\\+374|\\+375|\\+996|\\+373|\\+992|\\+998)+\\d+", Pattern.CASE_INSENSITIVE);

        private static boolean isItSNG(String someNumber)
        {
            Matcher matcher = VALID_SNG.matcher(someNumber);
            return matcher.find();
        }
        public SmsBody(String number, String text) {
            if (!isItSNG(number)) {
                throw new RuntimeException("phone: " + number + " it is not SNG!");
            }
            if (!hasOnlyDigits(number)) {
                throw new RuntimeException("phone: " + number + " has invalid format!");
            }
            if (!hasLengthMoreThan(text, SMS_TEXT_MESSAGE_MIN_LENGTH)) {
                throw new RuntimeException("message: " + text + " is too short!");
            }
            this.number = number;
            this.text = text;
        }
       /* public static void main(String[]args)
        {
            System.out.println();
        }*/
    }

}
