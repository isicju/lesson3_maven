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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmailNotificationService {

    public static void main(String[] args) throws InterruptedException {
        String name = "";
        String password = "";


        String recipient = "danilaevd7@gmail.com";
        String textMessage = "{\n" +
                "\n" +
                "\"time\":\"2022-02-21 10:00\",\n" +
                "\n" +
                "\"label\":\"Office standup meeting\"\n" +
                "\n" +
                "}";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String dateTimeInMessage = "2022-12-23 23:20";
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime startTime = LocalDateTime.now();
        while (!dateTimeInMessage.contains(currentDateTime.format(dateTimeFormatter))) {
            Thread.sleep(3000);
            System.out.println("wait send");

            currentDateTime = LocalDateTime.now();
            if(startTime.plusMinutes(1) == currentDateTime){
                System.out.println("message no send, time is over 1 minute");
                break;
            }
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
    }

    public static void main1(String[] args) {
        String username = "";
        String password = "";

        String phone = "";
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
