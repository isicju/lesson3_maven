package org.example.exceptions;

import org.example.online.Client;

public class RuntimeExceptions {

    public void throwsNullPointerException(){
        String myString = null;
        myString.length();
    }

    public void throwsArrayIndexOutOfBoundsException(){
        int[] arr = {1};
        System.out.println(arr[1]);
    }

    public void throwsNumberFormatException(){
        String s = "4o4";
        Integer number = Integer.parseInt(s);
        System.out.println(number);
    }

    public void throwsIllegalArgumentException(){
        Client client = null;
       SomeMethod(client);
    }

    public static void throwsClassCastException(){
        Integer x = 100;
        Object object = x;
        SomeMethod(object);
    }

    private static void SomeMethod(Object arg)
    {
        if(arg == null)
            throw new IllegalArgumentException();

        System.out.println((String) arg);
    }
}
