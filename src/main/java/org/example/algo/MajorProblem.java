package org.example.algo;

public class MajorProblem {

    public int findMajorityElement(int[] arr) {
        if (arr == null)
            throw new NullPointerException("Array reference is null");
        int maxFrequent = 0;
        int num = 0;
        for (int j : arr) {
            int frequent = 0;
            for (int k : arr) {
                if (j == k) frequent++;
                if (frequent > maxFrequent) {
                    maxFrequent = frequent;
                    num = j;
                }
            }
        }
        return num;
    }
}