package org.example.bubbleSorter;

import java.util.ArrayList;

public class bubbleSorter {
        public static ArrayList<Integer> arrayToSort = new ArrayList<>();

        public static void generateArray() {
            do {
                int maxSizeOfArray = 100;
                int maxValueOfArray = 100;
                int randomArraySize = (int) (Math.random() * maxSizeOfArray);
                for (int i = 0; i < randomArraySize; i++) {
                    int symbol = Math.random() > 0.49 ? 1 : (-1);
                    int newListValue = (int) (Math.random() * maxValueOfArray * symbol);
                    arrayToSort.add(newListValue);
                }
            }
            while (arrayToSort.size() == 0);
        }

        public static void bubbleSort(ArrayList<Integer> list, boolean directionSwitcher) {
            if (directionSwitcher) {
                for (int i = 0; i < list.size() - 1; i++) {
                    for (int j = 0; j < (list.size() - i - 1); j++) {
                        int left = list.get(j);
                        int right = list.get(j+1);
                        if (left > right) {
                            list.set(j, right);
                            list.set(j+1, left);
                        }
                    }
                }
            }
            else {
                for (int i = 0; i < list.size() - 1; i++) {
                    for (int j = 0; j < (list.size() - i - 1); j++) {
                        int right = list.get(list.size() - j - 1);
                        int left = list.get(list.size() - j - 2);
                        if (left < right) {
                            list.set(list.size() - j - 2, right);
                            list.set(list.size() - j - 1, left);
                        }
                    }
                }
            }
        }
    }
