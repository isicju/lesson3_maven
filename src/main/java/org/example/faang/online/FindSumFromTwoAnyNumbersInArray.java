package org.example.faang.online;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindSumFromTwoAnyNumbersInArray {
    //1, 3,7, 11 : 22 => false
    //1, 17, 5, 2: 22 => true
    //N^2
    // log(N)*N + log(N)*N
    public static boolean hasSumOnline(int[] elements, int target) {
        for (int i = 0; i < elements.length; i++) {
            int firstNum = elements[i];
            for (int j = 0; j < elements.length; j++) {
                int secondNum = elements[j];
                if (firstNum + secondNum == target) return true;
            }
        }
        return false;
    }

    public static boolean hasSumOnlineUsing(int[] elements, int target) {
        Set<Integer> allPreviousElements = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            int firstNum = elements[i];
            allPreviousElements.add(firstNum); //C1
            if (allPreviousElements.contains(target - firstNum)) return true;
        }
        return false;
    }


}
