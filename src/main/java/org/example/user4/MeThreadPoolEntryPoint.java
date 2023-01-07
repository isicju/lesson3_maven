package org.example.user4;


public class MeThreadPoolEntryPoint {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(4);
        myThreadPool.shutdown();

        for (int i = 0; i < 1000; i++) {
            myThreadPool.addTak(new Runnable() {
                @Override
                public void run() {
                    System.out.println("current thread: " + Thread.currentThread().getName());
                }
            });
        }

    }
}
