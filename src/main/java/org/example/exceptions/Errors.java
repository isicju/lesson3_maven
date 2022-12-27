package org.example.exceptions;

import java.util.LinkedList;
import java.util.List;

public class Errors {

    public void throwsOOOException(){
        List<byte[]> list = new LinkedList<>();
            while (true) {
                byte[] b = new byte[10 * 1024 * 1024]; // 10MB byte object
                list.add(b);
            }
    }

    public void throwsStackOverFlowError(){
        calculateFactorial(3);
    }

    private int calculateFactorial(int number) {
        return number * calculateFactorial(number - 1);
    }
}
