package org.example.exceptions;

import java.util.ArrayList;

public class Errors {

    public void throwsOOOException(){ //нехватка памяти
        ArrayList<Integer> array = new ArrayList<>();
        while(true) {
            array.add(10);
        }
    }

    public void throwsStackOverFlowError(){ //переполнение стека

        throwsStackOverFlowError();
    }
}
