package org.example.exceptions;

public class Errors {

    public void throwsOutOfMemoryError() {
        String[] myArray = new String[2147483647];
    }

    public void throwsStackOverFlowError() {
        System.out.println("InfiniteRecursion.jpg");
        throwsStackOverFlowError();
    }

}
