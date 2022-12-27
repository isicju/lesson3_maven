package org.example.exceptions;

import java.util.LinkedList;
import java.util.List;

public class Errors {

    public void throwsOOOException(){
        List<byte[]> list = new LinkedList<>();
        try {
            while (true) {
                byte[] b = new byte[10 * 1024 * 1024]; // 10MB byte object
                list.add(b);
            }
        }
        catch (OutOfMemoryError e) {
            System.out.println("There is no free memory so far!");
        }
    }

    public void throwsStackOverFlowError(){
            try {
                calculateFactorial(3);
            }
            catch (StackOverflowError e) {
                System.out.println("Hello StackOverFLow!");
            }
    }

    private int calculateFactorial(int number) {
        return number * calculateFactorial(number - 1);
    }
}
