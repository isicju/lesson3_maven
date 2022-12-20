package org.example.exceptions;

public class RuntimeExceptions {

    public void throwsNullPointerException(){
        String myString = null;
        myString.length();
    }

    public void throwsArrayIndexOutOfBoundsException(){
        Integer[] arr = new Integer[1];
        System.out.println(arr[2]);

    }

    public void throwsNumberFormatException(){
        Integer.parseInt(null);
    }

    public void throwsIllegalArgumentException() throws InterruptedException {
        System.getProperty("");
    }

    public static void throwsClassCastException(){
        Object obj = new String("Hello");
        System.out.println((Integer) obj);
    }

}
