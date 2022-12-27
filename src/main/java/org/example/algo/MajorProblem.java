package org.example.algo;

import java.util.Arrays;

public class MajorProblem {
// Для заданного массива вернуть число которое встречается чаще всех остальных
//Input : [2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2]
//Output: 2
//
//Input : [1, 3, 1, 1]
//Output: 1

    public static int findMajorityElement(int[] input) {
        // O(N) algorithm complexity
        Arrays.sort(input);
        int currentMaxValue = input[0];
        int currentMaxValueCounter = 1;
        int potentialMaxValueCounter = 1;
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == input[i + 1]) potentialMaxValueCounter++;
            else {
                if (currentMaxValueCounter < potentialMaxValueCounter) {
                    currentMaxValueCounter = potentialMaxValueCounter;
                    potentialMaxValueCounter = 1;
                    currentMaxValue = input[i];
                } else potentialMaxValueCounter = 1;
            }
        }
        return currentMaxValue;
    }
}