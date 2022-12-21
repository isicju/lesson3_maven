package org.example.exceptions;

import java.util.ArrayList;

public class Errors {
    public static void main(String[] args) {
        throwsStackOverFlowError();
        throwsOOOException();
    }

    public static void throwsOOOException(){
        ArrayList<Integer> array = new ArrayList<>();
        while(true) {
            array.add(10);
        }
    }

    public static void throwsStackOverFlowError(){
        throwsStackOverFlowError();
    }
}
