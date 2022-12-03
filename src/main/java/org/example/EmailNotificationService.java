package org.example;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;


public class EmailNotificationService {

    public static void main(String[] args) {
        String name = "";
        String password = "";
        String recipient = "isicju@gmail.com";
        String textMessage = "bla";

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
