package org.example.exceptions;

import java.util.ArrayList;
import java.util.List;

public class Errors {

    public void throwsOOOException(){
        List<Integer> list = new ArrayList<>();
        while(true){
            list.add(Integer.MAX_VALUE);
        }
        }


    public void throwsStackOverFlowError(){
        myMethod();
        }

    public void myMethod(){
        myMethod();
    }
}
