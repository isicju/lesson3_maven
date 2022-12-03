package org.example;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

public class EmailNotificationService {

    public static void main1(String[] args) {
        String name = "53ffc361c9d9692e9060ef89c18f1c11";
        String password = "47db15682b550bdf44e2609e94c0dd4a";

        String recipient = "isicju@gmail.com";
        String textMessage = "kekekek";

        ClientOptions options = ClientOptions.builder()
                .apiKey(name)
                .apiSecretKey(password)
                .build();

        MailjetClient client = new MailjetClient(options);
        MailjetRequest request = new MailjetRequest(Emailv31.resource)
                .property(Emailv31.MESSAGES, new JSONArray()
                        .put(new JSONObject()
                                .put(Emailv31.Message.FROM, new JSONObject()
                                        .put("Email", "isicju@gmail.com")
                                        .put("Name", "Me"))
                                .put(Emailv31.Message.TO, new JSONArray()
                                        .put(new JSONObject()
                                                .put("Email", recipient)
                                                .put("Name", "Java course 2022 nov")))
                                .put(Emailv31.Message.SUBJECT, "Subject")
                                .put(Emailv31.Message.HTMLPART, "<h1>" + textMessage + "</h1>")));
        try {
            client.post(request);
        } catch (MailjetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String username = "isicju@gmail.com";
        String password = "MjHqfCWBKh63W12Ognw5aM4XzR";

        String phone = "79681907742";
        String message = "testfromjavacourse";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")));
            set("Authorization", "Basic " + new String(encodedAuth));
            set("Content-Type", "application/json");
        }};


        String body = "{\"number\":" + phone + ", \"text\":\"" + message + "\",\"sign\":\"SMS Aero\"}";
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        restTemplate.postForObject("https://gate.smsaero.ru/v2/sms/send", request, String.class);

    }


}
