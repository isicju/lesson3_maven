package org.example.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RuntimeExceptions {

    public void throwsNullPointerException(){
        String myString = null;
        myString.length();
    }

    public void throwsArrayIndexOutOfBoundsException(){
        String[] array = {"123", "17"};
        array[2] = "adas";
    }

    public void throwsNumberFormatException(){
        Integer.parseInt("sur");

    }

    public void throwsIllegalArgumentException(){
        List<String> list = new ArrayList<>(-1);

    }

    public static void throwsClassCastException(){
        Object i = Integer.valueOf(1000);
        StringBuilder s = (StringBuilder)i;
    }

}
