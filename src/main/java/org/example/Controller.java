package org.example;

import org.example.service.EmailNotificationService;
import org.example.service.NotificationService;
import org.example.service.SmsNotificationService;

import java.util.HashMap;
import java.util.Map;

public class Controller {

   static Map<DELIVERY_CHANNEL, NotificationService> lookup = new HashMap<>();

    public static void init() {

        // authentication info


        NotificationService emailService =  new EmailNotificationService(emailName, emailPassword);
        lookup.put(DELIVERY_CHANNEL.EMAIL, emailService);

        NotificationService smsService = new SmsNotificationService(smsLogin, smsPassword);
        lookup.put(DELIVERY_CHANNEL.SMS, smsService);

    }


    public void sendMessage(DELIVERY_CHANNEL deliveryChannel, String recipient, String content) {
        lookup.get(deliveryChannel).sendMessage(recipient, content);
    }

    enum DELIVERY_CHANNEL {
        SMS, EMAIL, TELEGRAM
    }


}
