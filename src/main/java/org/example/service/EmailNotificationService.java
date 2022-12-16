package org.example.service;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.resource.Emailv31;
import org.example.StringValidationUtils;
import org.example.model.EmailMessage;
import org.json.JSONArray;
import org.json.JSONObject;

import static org.example.StringValidationUtils.*;

public class EmailNotificationService implements NotificationService {

    private final MailjetClient client;

    public EmailNotificationService(String name, String password) {
        ClientOptions options = ClientOptions.builder()
                .apiKey(name)
                .apiSecretKey(password)
                .build();
        client = new MailjetClient(options);
    }

    JSONArray buildManyJsonMails(JSONObject jsonMail) {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(jsonMail);
        return jsonArray;
    }

    JSONObject buildJsonMailContent(EmailMessage emailMessage) {
        return new JSONObject()
                .put(Emailv31.Message.FROM, new JSONObject()
                        .put("Email", "isicju@gmail.com")
                        .put("Name", "Me"))
                .put(Emailv31.Message.TO, new JSONArray()
                        .put(new JSONObject()
                                .put("Email", emailMessage.getEmail())
                                .put("Name", "Java course 2022 nov")))
                .put(Emailv31.Message.SUBJECT, "Subject")
                .put(Emailv31.Message.HTMLPART, "<h1>" + emailMessage.getTextMessage() + "</h1>");
    }

    @Override
    public void sendMessage(String recipient, String content) {
        if (validSendMessage(recipient)) {
            EmailMessage emailMessage = new EmailMessage(recipient, content);
            JSONObject jsonMail = buildJsonMailContent(emailMessage);
            JSONArray mails = buildManyJsonMails(jsonMail);

            MailjetRequest request = new MailjetRequest(Emailv31.resource)
                    .property(Emailv31.MESSAGES, mails);
            try {
                client.post(request);
            } catch (MailjetException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("You can only send by mail: .gmail\n" +
                    "And your mail:" + recipient + " does not match .gmail");
        }
    }
}
