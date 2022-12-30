package org.example;

import org.example.model.Task;
import org.example.notification.Notifier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.example.DateUtil.isWithinInterval;

public class TaskScheduler {

    private Task internalTask;
    private Notifier notifier;

    private static final long TEN_SECONDS = 10000;
    private List<Task> previouslyActivatedTasks = new ArrayList<>();

    public TaskScheduler(Task internalTask, Notifier notifier) {
        this.internalTask = internalTask;
        this.notifier = notifier;
    }

    public void schedule(long period) throws InterruptedException {
        while (true){
            System.out.println("running scheduler...");
            Thread.sleep(period);
            if (isWithinInterval(internalTask.getTime(), System.currentTimeMillis() , TEN_SECONDS)){
                if(!previouslyActivatedTasks.contains(internalTask)){
                    notifier.sendNotification(internalTask);
                    previouslyActivatedTasks.add(internalTask);
                }else{
                    System.out.println("task was already used!");
                }
            }else{
                System.out.println("task with time: " + internalTask.getTime() + " is outside of current time!");
            }
        }
    }



}
