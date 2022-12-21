package org.example.exceptions;

import java.util.Scanner;

import static java.lang.System.in;

public class RuntimeExceptions {
    public static void main(String[] args) {
        throwsIllegalArgumentException();
    }

    public void throwsNullPointerException(){
        String myString = null;
        myString.length();
    }

    public void throwsArrayIndexOutOfBoundsException(){
        int [] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            array[6] = 5;
        }
    }

    public void throwsNumberFormatException(){
        int number = 234;
        String str = "run";
        number = Integer.parseInt(str);
    }

    public static void throwsIllegalArgumentException(){
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        System.out.println(value);
    }

    public void throwsClassCastException() {
        Object value = Integer.valueOf(5);
        String str = (String) value;
    }

}
