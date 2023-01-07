package org.example.user4;

public class ThreadDaemon {

    public static void main(String[] args) {
        System.out.println(Thread.getAllStackTraces());
        Thread notDaemon = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = 0;
                    while (!Thread.currentThread().isInterrupted()) {
                        i++;
                    }
                    System.out.println("Child thread was completed: " + Thread.currentThread().getName());
                } finally {
                    System.out.println("finally worked");
                }
            }
        }, "Child thread");
        notDaemon.setDaemon(true);
        notDaemon.start();
        System.out.println("Main thread completed " + Thread.currentThread().getName());
//        notDaemon.interrupt();
    }

}
