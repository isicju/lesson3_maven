package org.example.faang;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumFromTwoNumbers {

    public static boolean hasSum(int[] elements, int targetSum) {
        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[i] + elements[j] == targetSum) return true;
            }
        }
        return false;
    }

    public static boolean hasSumUsingMap(int[] elements, int targetSum) {
        Set<Integer> numMap = new HashSet<>();
        for (int i = 0; i < elements.length; i++) {
            int current = elements[i];
            numMap.add(current);
            if (numMap.contains(targetSum - current)) {
                return true;
            }
        }
        return false;
    }

}
