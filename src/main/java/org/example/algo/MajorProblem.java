package org.example.algo;

import java.util.Arrays;

public class MajorProblem {
// Для заданного массива вернуть число которое встречается чаще всех остальных
//Input : [2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2]
//Output: 2
//
//Input : [1, 3, 1, 1]
//Output: 1

//Если таких чисел несколько, то вернуть наибольшее

    public int findMajorityElement(int[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Массив должен содержать целые числа");
        }
        int target = 0;
        Arrays.sort(input);
        target = input[input.length - 1]; // по умолчанию возвращается наибольшее число в массиве
        int counter = 1; // счётчик повторений элементов
        int maxCounter = 1; // максимальное количество повторений элементов
        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i - 1])
                counter++;
            else
                counter = 1;
            if (counter >= maxCounter) {
                maxCounter = counter;
                target = input[i];
            }
        }
        return target;
    }

}
