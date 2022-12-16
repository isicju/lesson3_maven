package org.example;


import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        System.out.println("works");
    }

    // myChars.length -> N
    public String inverseString(String myChars) {
        byte[] myCharsByteArray = myChars.getBytes(); // N
        byte[] invertedByteArray = new byte[myCharsByteArray.length]; // C -> N


        for (int i = 0; i < myCharsByteArray.length; i++) {
            invertedByteArray[myCharsByteArray.length - i - 1] = myCharsByteArray[i]; // 10
        }

        return new String(invertedByteArray);
    }


    public boolean hasSum(int[] input, int sum) {
        for (int i = 0; i < input.length; i++) {
            int firstNum = input[i];
            for (int j = i + 1; j < input.length; j++) {
                int secondNum = input[j];
                if (firstNum + secondNum == sum) return true;
            }
        }
        return false;
    }

    // Homework 4 Algo
    public String helloWorld() {
        return "hello world";
    }

    public static int[] BubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j-1] > array[j]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        return array;
    }

}
