package org.example.algo;

public class MajorProblem {
// Для заданного массива вернуть число которое встречается чаще всех остальных
//Input : [2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2]
//Output: 2
//
//Input : [1, 3, 1, 1]
//Output: 1

    private static int findMajorityElement(int[] input) throws IllegalArgumentException {
        int number = 0;
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input.length; j++) {
                    if (input[i] < 0) {
                        throw new IllegalArgumentException();
                    }
                    if (input[i] == input[j]) {
                        number = input[j];
                    }
                }
            }
        return number;
    }

    public static void main(String[] args) {
            System.out.println(findMajorityElement(new int[]{2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2}));
    }
}
