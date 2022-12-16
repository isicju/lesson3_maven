package org.example;


import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        System.out.println("works");
        bubbleSort(new int[]{3, 5, 4});

    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        return array;
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

    public String helloWorld() {
        return "hello world";
    }



}
