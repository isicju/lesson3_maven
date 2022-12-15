package org.example.pathFinder;

import java.util.ArrayList;
import java.util.HashMap;

public class PathFinder {

        public static boolean hasConnectionBetween(String firstWord, String secondWord, String[] wordsBetween) {

            char[] firstToChar = firstWord.toCharArray();
            char[] secondToChar = secondWord.toCharArray();
            char[][] betweenersToChar = new char[wordsBetween.length][];
            for (int i = 0; i < wordsBetween.length; i++) {
                betweenersToChar[i] = wordsBetween[i].toCharArray();
            }
            HashMap<Integer, String> WhatWeHave = whatDoWeHaveToCheck(firstToChar, secondToChar, betweenersToChar);
            HashMap<Integer, String> whatWeHaveToHave = rightMatchesFinder(firstWord);
            System.out.println("Имеющийся попарный список совпадений: " + WhatWeHave);
            System.out.println("Требуемый попарный список совпадений: " + whatWeHaveToHave);
            return compareAndResult(WhatWeHave, whatWeHaveToHave, secondWord);
        }

        public static ArrayList<Integer> matchesArray(char[] firstOfSecond, char[][] betweeners) {
            ArrayList<Integer> matchesToArray = new ArrayList<>();
            int matches = 0;
            for (char[] betweener : betweeners) {
                for (int j = 0; j < betweener.length; j++) {
                    if (betweener[j] == firstOfSecond[j]) {
                        matches++;
                    }
                }
                matchesToArray.add(matches);
                matches = 0;
            }
            return matchesToArray;
        }

        public static HashMap<Integer, String> whatDoWeHaveToCheck(char[] firstWord, char[] secondWord, char[][] betweeners) {
            HashMap<Integer, String> whatDoWeHaveToCheck = new HashMap<>();
            ArrayList<Integer> firstWordArrayOfMatches = matchesArray(firstWord, betweeners);
            ArrayList<Integer> secondWordArrayOfMatches = matchesArray(secondWord, betweeners);
            for (int i = 0; i < firstWordArrayOfMatches.size(); i++) {
                String value = firstWordArrayOfMatches.get(i) + " " + secondWordArrayOfMatches.get(i);
                whatDoWeHaveToCheck.put(i, value);
            }
            return whatDoWeHaveToCheck;
        }

        public static HashMap<Integer, String> rightMatchesFinder(String word) {
            HashMap<Integer, String> rightMatchesMap = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                String value = word.length() - 1 - i + " " + (word.length() - (word.length() - 1 - i));
                rightMatchesMap.put(i, value);
            }
            return rightMatchesMap;
        }
        public static boolean compareAndResult(HashMap one, HashMap two, String word) {
            int compareCounter = 0;
            for (int i = 0; i < one.size(); i++) {
                for (int j = 0; j < two.size(); j++) {
                    if (one.get(i).equals(two.get(j))) {
                        compareCounter++;
                        break;
                    }
                }

            }
            if (compareCounter == word.length()) {
                System.out.println("Связка есть!");
                return true;
            }
            else {
                System.out.println("Связки нет.");
                return false;
            }
        }
    }
