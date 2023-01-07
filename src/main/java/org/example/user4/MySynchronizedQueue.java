package org.example.user4;

import java.util.LinkedList;
import java.util.Queue;

public class MySynchronizedQueue {

    private static final int MAX_SIZE = 10;
    private final Queue<String> queue = new LinkedList<>();
    private final Object lock = new Object();

    public MySynchronizedQueue() {
    }

    public void push(String item)  {
        synchronized (lock) {
            while (queue.size() == MAX_SIZE) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            queue.add(item);
            lock.notifyAll();
        }
    }

    public String poll() {
        synchronized (lock) {
            while (queue.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            return queue.poll();
        }
    }
}
