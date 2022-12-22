package org.example.exceptions;

import java.util.Date;

public class RuntimeExceptions {

    public void throwsNullPointerException() {
        String myString = null;
        myString.length();
    }

    public void throwsArrayIndexOutOfBoundsException() {
        int[] array = new int[0];
        array[0]++;
    }

    public void throwsNumberFormatException() {
        Integer e = new Integer("A");
    }

    public void throwsIllegalArgumentException() {
        Date date = new Date("A");
    }

    public static void throwsClassCastException() {
        Object object = new Object();
        RuntimeExceptions test = (RuntimeExceptions) object;
    }

}
