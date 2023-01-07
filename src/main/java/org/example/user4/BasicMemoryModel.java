package org.example.user4;

public class BasicMemoryModel {
    static Integer myValue = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(" print me ");
            }
        });

        thread.run();
    }



}
