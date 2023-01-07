package org.example.user4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyThreadPool {
    private Queue<Runnable> workers = new ConcurrentLinkedQueue<>();
    private AtomicBoolean isShutDown = new AtomicBoolean(false);

    public void shutdown() {
        this.isShutDown.set(true);
    }

    public void addTak(Runnable runnable) {
        workers.add(runnable);
    }

    public MyThreadPool(int threadsNumber) {
        for (int i = 0; i < threadsNumber; i++) {
            (new Thread(new Runnable() {
                @Override
                public void run() {
//                    System.out.println("current thread: " + Thread.currentThread().getName() + "started");
                    while (!isShutDown.get()) {
//                        System.out.println(" checking status of tasks: " + Thread.currentThread().getName());
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        Runnable task = workers.poll();
                        if (task != null) {
                            task.run();
                        }
                    }
                }
            }, "Child " + i)).start();
        }
    }
}
