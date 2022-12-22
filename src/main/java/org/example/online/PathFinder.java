package org.example.online;

public class PathFinder {

    public boolean hasConnection(String head, String tail, String[] words) {
        if (!isValidInputHeadAndTail(head, tail)) return false;
        String current = head;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (findWords(current, words[i])) {
                    current = words[i];
                } else {
                    break;
                }
            }
        }
        return findWords(current, tail);
    }

    private boolean isValidInputHeadAndTail(String head, String tail) {
        boolean isValidHead = head != null && head.length() == 3;
        boolean isValidTail = tail != null && tail.length() == 3;
        return isValidTail && isValidHead;
    }

    public static boolean findWords(String firstWord, String secondWord) {
        char[] firstArray = firstWord.toCharArray();
        char[] secondArray = secondWord.toCharArray();
        int diffCount = 0;
        while (true) {
            for (int i = 0; i < firstWord.length(); i++) {
                if (firstArray[i] != secondArray[i]) {
                    diffCount = diffCount + 1;
                }
            }
            if (diffCount == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

//    public boolean hasConnection(String head, String tail, String[] words) {
//        if(!isValidInputHeadAndTail(head,tail)) return false;
//        String current = head;
//        for (String nextCurrent : words) {
//           if (!hasOneCharDifference(current, nextCurrent)) {
//                break;
//            }
//            current = nextCurrent;
//        }
//        return hasOneCharDifference(current, tail);
//    }
//
//    private boolean isValidInputHeadAndTail(String head, String tail) {
//        boolean isValidHead = head != null && head.length() == 3;
//        boolean isValidTail = tail != null && tail.length() == 3;
//        return isValidTail && isValidHead;
//    }
//
//    public boolean hasOneCharDifference(String left, String right) {
//        //3 comparison
//        byte[] leftBytes = left.getBytes();
//        byte[] rightBytes = right.getBytes();
//        int diffCount = 0;
//        for (int i = 0; i < leftBytes.length; i++) {
//            if (leftBytes[i] != rightBytes[i]) {
//                diffCount = diffCount + 1;
//            }
//        }
//        return diffCount == 1;
//    }

}
