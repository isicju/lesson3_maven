package org.example.exceptions;

import java.util.*;

public class Errors {

    public void throwsOOOException(){
        Map m = new HashMap();
        //m.System.getProperties();
        Random r = new Random();
        while(true) {
            m.put(r.nextInt(), "value");
        }
    }

    public void throwsStackOverFlowError(){
        methodForTestThrowsStackOverFlowError(1);
    }
    public void methodForTestThrowsStackOverFlowError(int number) {
        methodForTestThrowsStackOverFlowError(number - 1);
    }
}
