package org.example.online;

public class PathFinder {

    public boolean hasConnection(String head, String tail, String[] words) {
        if(!isValidInputHeadAndTail(head,tail)) return false;
        String current = head;
        for (String nextCurrent : words) {
           if (!hasOneCharDifference(current, nextCurrent)) {
                break;
            }
            current = nextCurrent;
        }
        return hasOneCharDifference(current, tail);
    }

    private boolean isValidInputHeadAndTail(String head, String tail) {
        boolean isValidHead = head != null && head.length() == 3;
        boolean isValidTail = tail != null && tail.length() == 3;
        return isValidTail && isValidHead;
    }

    public boolean hasOneCharDifference(String left, String right) {
        //3 comparison
        byte[] leftBytes = left.getBytes();
        byte[] rightBytes = right.getBytes();
        int diffCount = 0;
        for (int i = 0; i < leftBytes.length; i++) {
            if (leftBytes[i] != rightBytes[i]) {
                diffCount = diffCount + 1;
            }
        }
        return diffCount == 1;
    }

}
