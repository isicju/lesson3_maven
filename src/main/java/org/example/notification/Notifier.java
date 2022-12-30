package org.example.notification;

import org.example.model.Task;

public interface Notifier {
    void sendNotification(Task task);
}
