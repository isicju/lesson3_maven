package org.example.service;


public class PathFinderService {

    public static boolean hasConnectionBetweenTwoWords(String begging, String ending, String[] elements) {
        if (!isValidPathWordInputs(begging, ending, elements)) return false;


        String currentElement = begging;
        StringBuilder chain = new StringBuilder(" -> ");
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals("***")) continue;
            for (int j = 0; j < elements.length; j++) {
                if (hasOneCharDifference(currentElement, elements[j])) {
                    currentElement = elements[j];
                    elements[j] = "***";
                    break;
                }
            }
            chain.append(currentElement).append(" -> ");
        }
        System.out.println(begging + chain + ending);
        return hasOneCharDifference(currentElement, ending);
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
