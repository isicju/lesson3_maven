package org.example.exceptions;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.*;

public class RuntimeExceptions {

    private List<String> getNotNullStringList(int length) {
        List<String> myList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder("fag");
        for (int i = 0; i < length; i++) {
            myList.add(stringBuilder.toString());
            stringBuilder.append(i);
        }
        return myList;
    }

    public void throwsNullPointerException() {
        // Init an stringList with some strings and one null;
        List<String> myList = getNotNullStringList(5);
        myList.set(4, null);

        //Try to print the whole list
        for (String line : myList) {
            line.strip().length();
        }


    }

    public void throwsArrayIndexOutOfBoundsException() {
        // Example case: looking through an array through an infinite loop
        List<String> myList = getNotNullStringList(5);
        int i = 0;
        while (true) {
            myList.get(i);
            i++;
        }
    }

    // Throws NumberFormatException
    public void saveFavouriteNumber(String favouriteNumber) {
        //Example case : Service: enter please your favourite number
        Integer aIntObj = valueOf(favouriteNumber);

        // Adding commercial info to database
    }

    // Throws IllegalArgumentException
    public void processSomethingNotNull(Object myParameter) {
        if (myParameter == null) {
            throw new IllegalArgumentException("Parameter 'myParameter' cannot be null");
        }
    }

    // Throws ClassCastException
    public void saveFavouriteNumber2(Object myParameter) {
        //Example case : Service takes your favourite number
        // and add it to a database. Trainee added an object to signature.

        if (myParameter == null) {
            throw new IllegalArgumentException("Parameter 'myParameter' cannot be null");
        }
        Integer favouriteInteger = (Integer) myParameter;
        // Add commercial info to database;

    }
}
