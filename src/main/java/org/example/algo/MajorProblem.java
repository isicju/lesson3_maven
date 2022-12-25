package org.example.algo;

import java.util.HashMap;

public class MajorProblem {

    // O(N) .
    // Можно реализовать через два массива по тому же принципу.
    public static int findMajorityElement(int[] input){
            //Map <integer, number of times it appears in the array>
        HashMap<Integer, Integer> numberTimesAppears = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            // Method increase the value for the current integer or put 1 by default
            numberTimesAppears.merge(input[i], 1, (prev, one) -> prev +1);
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
