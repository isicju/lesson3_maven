package org.example.exceptions;

import java.util.Date;

public class RuntimeExceptions {
    
    public void throwsNullPointerException() {
        String myString = null;
        myString.length();
    }
    
    public void throwsArrayIndexOutOfBoundsException() {
        int[] myArray = new int[10];
        for (int i = 0; i < 11; ++i) {
            int item = myArray[i];
        }
    }
    
    public void throwsNumberFormatException() {
        Integer intValue = Integer.parseInt("2_147_483_648");
    }
    
    public void throwsIllegalArgumentException() {
        Date date = new Date("error");
    }
    
    public void throwsClassCastException() {
        Object error = Integer.valueOf(777);
        String str = (String) error;
    }
    
}
