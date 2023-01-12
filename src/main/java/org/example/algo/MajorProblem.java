package org.example.algo;

import java.util.HashMap;
import java.util.Map;


public class MajorProblem {
// Для заданного массива вернуть число которое встречается чаще всех остальных
//Input : [2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2]
//Output: 2
//
//Input : [1, 3, 1, 1]
//Output: 1
    public int findMajorElement(int[] arr){

        if(arr == null)
            throw new NullPointerException("this is not array");

        if(arr.length == 0)
            throw new ArrayIndexOutOfBoundsException("arr.length == 0");

        return findMajorityElement(arr);
    }
    private int findMajorityElement(int[] input){
        int maxi = -1;
        Integer maxVal =0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<input.length;++i) {
            Integer temp = map.get(input[i]);
            if(temp==null)
            {
               map.put(input[i],1);
               if(maxVal < 1){
                   maxVal = 1;
                   maxi = input[i];
               }
            }
            else {
                map.put(input[i],temp+1);
                if(maxVal < temp+1){
                    maxVal = temp+1;
                    maxi = input[i];
                }
            }

        }
        return maxi;
    }

}
