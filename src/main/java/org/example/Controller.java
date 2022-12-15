package org.example;

import org.example.service.EmailNotificationService;
import org.example.service.NotificationService;
import org.example.service.SmsNotificationService;

import java.util.HashMap;
import java.util.Map;

public class Controller {

   static Map<DELIVERY_CHANNEL, NotificationService> lookup = new HashMap<>();

    public static void init(String[] args) {
        String emailName = ""; //check  in group
        String emailPassword = ""; //check  in group
        NotificationService emailService =  new EmailNotificationService(emailName, emailPassword);

        String name = ""; //check  in group
        String password = ""; //check in group

        NotificationService smsService = new SmsNotificationService(name, password);

        lookup.put(DELIVERY_CHANNEL.EMAIL, emailService);
        lookup.put(DELIVERY_CHANNEL.SMS, smsService);
    }

//    public void sendMessage(DELIVERY_CHANNEL deliveryChannel, String recipient, String content) {
//        lookup.get(DELIVERY_CHANNEL.SMS).sendMessage(recipient, content);
//    }

    enum DELIVERY_CHANNEL {
        SMS, EMAIL, TELEGRAM
    }


}
