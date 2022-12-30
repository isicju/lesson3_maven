package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.model.Task;
import org.example.notification.ConsoleNotificationService;
import org.example.notification.Notifier;

public class Main {

    private final static long FIVE_SECONDS = 5000;
    private static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm";

    public static void main(String[] args) throws InterruptedException {
        String inputText = "{\"time\":\"2022-12-30 11:43\", \"label\":\"Office standup meeting\"}";
        Task task = convertJsonToTask(inputText);

        Notifier notifier = new ConsoleNotificationService();
        TaskScheduler scheduler = new TaskScheduler(task, notifier);
        scheduler.schedule(FIVE_SECONDS);
    }

    private static Task convertJsonToTask(String validJson) {
        try {
            Gson gson = new GsonBuilder().setDateFormat(DEFAULT_DATE_TIME_FORMAT).create();
            return (gson.fromJson(validJson, Task.class));
        } catch (Exception e) {
            throw new IllegalArgumentException(" not valid task json format: " + validJson);
        }
    }


}
