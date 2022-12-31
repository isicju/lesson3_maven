package org.example.exceptions;

public class RuntimeExceptions {

    public void throwsNullPointerException(){
        String myString = null;
        myString.length();
    }

    public void throwsArrayIndexOutOfBoundsException(){
        int[] numbers = new int[5];
        System.out.println(numbers[5]);
    }

    public void throwsNumberFormatException(){
        String wrongNumberFormat = "5q5";
        int number = Integer.parseInt(wrongNumberFormat);
    }

    public void throwsIllegalArgumentException(){
        methodForTestIllegalArgumentException(Integer.parseInt("kek"));
    }
    public void methodForTestIllegalArgumentException(int number) {
        return;
    }

    public static void throwsClassCastException(){
        Object x = new Integer(0);
        System.out.println((String)x);
    }

}
