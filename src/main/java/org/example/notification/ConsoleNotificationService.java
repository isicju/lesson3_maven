package org.example.notification;

import org.example.model.Task;

public class ConsoleNotificationService implements Notifier {
    @Override
    public void sendNotification(Task task) {
        System.out.println("Notifying task: " + task.getLabel());
    }
}
