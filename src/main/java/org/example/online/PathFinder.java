package org.example.online;

public class PathFinder {

    public boolean hasConnection(String head, String tail, String[] words) {
        if (!isValidPathWordInputs(head, tail, words)) return false;

        String currentElement = head;
        StringBuilder chain = new StringBuilder(" -> ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("***")) continue;
            for (int j = 0; j < words.length; j++) {
                if (hasOneCharDifference(currentElement, words[j])) {
                    currentElement = words[j];
                    words[j] = "***";
                    break;
                }
            }
            chain.append(currentElement).append(" -> ");
        }
        System.out.println(head + chain + tail);
        return hasOneCharDifference(currentElement, tail);
    }

    private static boolean isValidPathWordInputs(String begging, String ending, String[] elements) {
        if (begging == null || begging.isEmpty()) return false;
        if (ending == null || ending.isEmpty()) return false;
        if (elements == null || elements.length == 0) return false;
        for (String element : elements) {
            if (element == null || element.isEmpty()) return false;
        }
        return true;
    }

    private static boolean hasOneCharDifference(String left, String right) {
        byte[] leftBytes = left.getBytes();
        byte[] rightBytes = right.getBytes();
        boolean hasOneCharDifference = false;
        for (int i = 0; i < leftBytes.length; i++) {
            if (rightBytes[i] != leftBytes[i]) {
                if (hasOneCharDifference) {
                    return false;
                }
                hasOneCharDifference = true;
            }
        }
        return true;
    }
}

// Оценка сложности алгоритма: O(n^3)
