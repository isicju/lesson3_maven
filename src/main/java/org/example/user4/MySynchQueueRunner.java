package org.example.user4;

import java.util.UUID;

public class MySynchQueueRunner {


    public static void main(String[] args) {
        MySynchronizedQueue mySynchronizedQueue = new MySynchronizedQueue();
        for (int i = 0; i < 5; i++) {
            Writer writer = new Writer(mySynchronizedQueue);
            writer.setName("Writer" + i);
            writer.start();
        }
        for (int i = 0; i < 5; i++) {
            Reader reader = new Reader(mySynchronizedQueue);
            reader.setName("Writer" + i);
            reader.start();
        }

    }

    static class Writer extends Thread {
        Writer(MySynchronizedQueue queue) {
            super(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("write value " + UUID.randomUUID() + " from " + Thread.currentThread().getName());
                        queue.push(UUID.randomUUID() + " from " + Thread.currentThread().getName());
                    }
                }
            });
        }
    }

    static class Reader extends Thread {
        Reader(MySynchronizedQueue queue) {
            super(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("peek " + queue.poll() + " by " + Thread.currentThread().getName());
                    }
                }
            });
        }
    }

}
