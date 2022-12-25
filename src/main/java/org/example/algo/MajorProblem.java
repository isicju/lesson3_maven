package org.example.algo;

import java.util.HashMap;

public class MajorProblem {

    // Complexity: O(N)
    public static int findMajorityElement(int[] input){
            //Map <integer, number of times it appears in the array>
            // It can be implemented through two arrays on the same principle.
        HashMap<Integer, Integer> numberTimesAppears = new HashMap<>();

        for (int j : input) {
            // Method increase the value for the current integer or put 1 by default
            numberTimesAppears.merge(j, 1, (prev, one) -> prev + 1);
        }

        int maxNum = 0;
        int maxTimes = 0;

        for (Integer number : numberTimesAppears.keySet()){
            int numTimes = numberTimesAppears.get(number);
            if(maxNum < numTimes){
                maxNum = number;
                maxTimes = numTimes;
            }
        }
        return maxNum;
    }

}
