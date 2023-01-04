package org.example.exceptions;

public class Errors {
    
    public void throwsOOOException(){
        for (int i = 0; true; ++i) {
            new Thread() {
                public void run() {
                    try {
                        Thread.sleep(1000000);
                    } catch(InterruptedException e) { }
                }
            }.start();
        }
    }
    
    public void throwsStackOverFlowError(){
        recursiveMethod();
    }
    
    static void recursiveMethod() {
        String errror;
        recursiveMethod();
    }
}
