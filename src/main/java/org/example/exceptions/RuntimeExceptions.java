package org.example.exceptions;

import java.util.ArrayList;
import java.util.Arrays;

public class RuntimeExceptions {

    public void throwsNullPointerException(){
        String myString = null;
        myString.length();
    }

    public void throwsArrayIndexOutOfBoundsException(){
        int[] array = new int[]{1, 2};
        System.out.println(array[2]);
    }

    public void throwsNumberFormatException(){
        Integer.parseInt(null);
    }

    public void throwsIllegalArgumentException(){
            throw new IllegalArgumentException("Illegal argument!");
    }

    public static void throwsClassCastException(){
        String[] strArray = new String[] { "John", "Snow" };
        ArrayList<String> strList = (ArrayList<String>) Arrays.asList(strArray);
        System.out.println("String list: " + strList);
    }

}
