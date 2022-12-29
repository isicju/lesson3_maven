package org.example.algo;

public class MajorProblem {
// Для заданного массива вернуть число которое встречается чаще всех остальных
//Input : [2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2]
//Output: 2
//
//Input : [1, 3, 1, 1]
//Output: 1


    public int findMajorityElement(int[] input) throws NullPointerException{
        if (input == null){
            throw new NullPointerException("array is null!");
        }

        int maxCount = 0;
        int number = 0;

        for (int i = 0; i < input.length; i++) {
            int count = 0;
            for (int j = i + 1; j < input.length; j++) {
                if (input[i] == input[j]) {
                    count++;
                }
                if (count > maxCount) {
                    maxCount = count;
                    number = input[j];

                }
            }

        }
        return number;
    }
}

