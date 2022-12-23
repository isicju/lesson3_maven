package org.example.algo;


import java.util.*;


public class MajorProblem {
// Для заданного массива вернуть число которое встречается чаще всех остальных
//Input : [2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2]
//Output: 2
//
//Input : [1, 3, 1, 1]
//Output: 1

    public static int findMajorityElement(int[] input) {
        // Проверяем на пустой массиа
        if (input.length == 0) throw new IllegalArgumentException("Array is empty");

        // Считаем кол-во вхождений каждого числа
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            if (hashMap.containsKey(input[i])) {
                hashMap.put(input[i], hashMap.get(input[i]) + 1);
            } else hashMap.put(input[i], 1);
        }

        // Находим число с наибольшей частотой вхождения
        int result = (Collections.max(hashMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey());

        // Проверяем нет ли в массиве еще чисел с такой же частотой вхождения
        int count = 0;
        for (Integer num : hashMap.values())
            if (hashMap.get(result).equals(num)) count += 1;
        if (count > 1)
            throw new IllegalArgumentException("The array contains several numbers of the highest frequency");

        return result;
    }

}

