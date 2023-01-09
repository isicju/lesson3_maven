package org.example.exceptions;

import java.util.LinkedList;

public class Errors {

    static LinkedList<Object[]> listObj = null;

    public void throwsOOOException(){
        listObj = new LinkedList<>();
        while (true)
        {
            listObj.add(new Object[100]);
        }
    }

    public void throwsStackOverFlowError(){
        long x = nFactorial(1000);
    }

    private long nFactorial(int n){
        return n * nFactorial(n-1);
    }
}
