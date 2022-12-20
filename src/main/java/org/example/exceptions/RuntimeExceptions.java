package org.example.exceptions;

import java.text.DecimalFormat;

public class RuntimeExceptions {

    public void throwsNullPointerException() {
        String myString = null;
        myString.length();
    }

    public void throwsArrayIndexOutOfBoundsException() {
        String[] myArray = new String[10];
        String lastElement = myArray[10];
    }

    public void throwsNumberFormatException() {
        String myString = "five";
        Integer myInteger = Integer.valueOf(myString);
    }

    public void throwsIllegalArgumentException() {
        String myString = "nineteen ninety-nine";
        DecimalFormat df = new DecimalFormat("#,###");
        String formattedString = df.format(myString);
    }

    public static void throwsClassCastException() {
        Object myArrayOfPrimitives = new int[10];
        Integer[] myArrayOfIntegers = (Integer[]) myArrayOfPrimitives;
    }

}
