package org.example.algo;

import java.util.Arrays;

public class MajorProblem {
// Для заданного массива вернуть число которое встречается чаще всех остальных
//Input : [2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2]
//Output: 2
//
//Input : [1, 3, 1, 1]
//Output: 1

    public static int findMajorityElement(int[] input){
        Arrays.sort(input);
        int currentMaxValue = input[0];
        int currentMaxCounter = 1;
        int potentialMaxCounter = 1;
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == input[i+1]) {
                potentialMaxCounter++;
            }
            else {
                if (currentMaxCounter < potentialMaxCounter) {
                    currentMaxCounter = potentialMaxCounter;
                    potentialMaxCounter = 1;
                    currentMaxValue = input[i];
                }
                else potentialMaxCounter = 1;
            }
        }
        return currentMaxValue;
    }

}
