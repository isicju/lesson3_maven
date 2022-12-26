package org.example.service;

public class PathFinderService {

    public static boolean hasConnectionBetweenTwoWords(String begging, String ending, String[] elements) {
        if (!isValidPathWordInputs(begging, ending, elements)) return false;


        String[] fullSequence = new String[elements.length + 2];
        System.arraycopy(elements, 0, fullSequence, 1, elements.length);
        fullSequence[0] = begging;
        fullSequence[elements.length + 1] = ending;


        String previous = null;
        for (String current : fullSequence) {
            if (previous != null && !hasOneCharDifference(previous, current)) {
                return false;
            }
            previous = current;
        }
        return true;
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
