package org.example.user4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ThreadPool {
    private Queue<Runnable> tasks = new LinkedList<>();

    public void addTask(Runnable task) {
        tasks.add(task);
    }

    ThreadPool(int threadsNumber) {
        for (int i = 0; i < threadsNumber; i++) {
            (new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(100);
                            Runnable task = tasks.poll();
                            if (task != null) {
                                task.run();
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            })).start();
        }
    }


}
