package org.example.algo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MajorProblem {
// Для заданного массива вернуть число которое встречается чаще всех остальных
//Input : [2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2]
//Output: 2
//
//Input : [1, 3, 1, 1]
//Output: 1
    
    static int findMajorityElement(int[] input){
        Arrays.sort(input);
        int currentMaximumInclusions = 1;
        int currentEnableValue = 0;
        int valueMaximumInclusions =0;
        int MaximumInclusions = 0;
        for (int i = 1; i < input.length; i++){
            if (MaximumInclusions < currentMaximumInclusions) {
                MaximumInclusions = currentMaximumInclusions;
                valueMaximumInclusions = currentEnableValue;}
            if (input[i -1] == input[i]){
                currentMaximumInclusions += 1;
                currentEnableValue = input[i];
            } else {currentMaximumInclusions = 1;}
        }
        return valueMaximumInclusions;
    }

//    public static void main(String[] args) {
//        findMajorityElement(new int [] {});
//        //findMajorityElement(new int [] {2, 8, 7, 2, 7, 2, 5, 2, 3, 1, 2, 2, 5, 7, 5, 7, 7, 7});
//    }
}
