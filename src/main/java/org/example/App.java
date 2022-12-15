package org.example;


import org.example.pathFinder.PathFinder;

import static org.example.bubbleSorter.bubbleSorter.*;

public class App {

    public static void main(String[] args) {

        System.out.println("Домашка по алгоритмике: Задача 1.");

        generateArray();
        System.out.println("Несортированный список: " + arrayToSort.toString());
        bubbleSort(arrayToSort, true);
        System.out.println("Сортированный по возрастанию список: " + arrayToSort.toString());
        bubbleSort(arrayToSort, false);
        System.out.println("Сортированный по убыванию список: " + arrayToSort.toString());

        System.out.println("-------------------------");

        System.out.println("Домашка по алгоритмике: Задача 2.");
        String firstWord = "cat";
        String secondWord = "dog";
        String[] wordsBetween = new String[] {"cag", "cat", "dog", "fog", "pog"};
        PathFinder.hasConnectionBetween(firstWord, secondWord, wordsBetween);

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
