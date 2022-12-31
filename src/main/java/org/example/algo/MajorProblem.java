package org.example.algo;

public class MajorProblem {
// Для заданного массива вернуть число которое встречается чаще всех остальных
//Input : [2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2]
//Output: 2
//
//Input : [1, 3, 1, 1]
//Output: 1

// O(N^2)
    public int findMajorityElement(int[] input) {
        int majorityCounter = 0;
        int majorityElement = 0;
        for (int i = 0; i < input.length; i++) {
            int counter = 0;
            for (int j = i; j < input.length; j++) {
                if (input[i] == input[j]) counter++;
            }
            if (counter > majorityCounter) {
                majorityCounter = counter;
                majorityElement = input[i];
            }
        }
        return majorityElement;
    }
}
