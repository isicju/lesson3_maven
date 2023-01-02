package org.example;

import lombok.ToString;

import java.util.Arrays;

public class  SortArray {
    
    public static void main(String[] args) {
        
        int[] myArray = {45, 12, 5, 74, 91, 32, 89, 4, 11, 27};
        System.out.println("Original array - " + Arrays.toString(myArray));
        int tenpo;
        for (int i = 1; i < myArray.length; i++) {
            for (int j = 1; j < myArray.length; ++j) {
                if (myArray[j - 1] > myArray[j]) {
                    tenpo = myArray[j];
                    myArray[j] = myArray[j - 1];
                    myArray[j - 1] = tenpo;
                }
            }
        }
        System.out.println("  Sorted array - " + Arrays.toString(myArray));
    }
}


