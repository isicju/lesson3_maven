package org.example.user4;

import lombok.SneakyThrows;

public class ThreadWithInterruption {


    public static void main(String[] args) throws InterruptedException {
        Thread threadWithInterruption = new Thread(new Runnable() {
            @Override
            public void run() {
                String currentThreadName = Thread.currentThread().getName();
                System.out.println("Thread: " + currentThreadName + "started.");
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Thread was interrupted: " + currentThreadName);
                        break;
                    }
                    try {
                        processData();
                    } catch (Exception e) {
                        System.out.println("Exception was caught: " + e.getMessage());
                    }
                }
            }
        }, "Processor thread");

        threadWithInterruption.start();

        Thread.sleep(5000);
        threadWithInterruption.interrupt();
    }

    public static void processData() {
        //Thread.sleep
        System.out.println("processing.." + Thread.currentThread().getName());
    }

}
