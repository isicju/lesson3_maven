package org.example.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathFinder {

    public static boolean hasPath(String head, String tail, List<String> wordsBetween) {
        List<String> relatedWords = Collections.singletonList(head);
        while (!relatedWords.contains(tail) && !relatedWords.isEmpty()) {
            relatedWords = extractRelativeWords(relatedWords, wordsBetween);
            wordsBetween.removeAll(relatedWords);
        }
        return relatedWords.isEmpty();
    }

    private static List<String> extractRelativeWords(List<String> relatedWords, List<String> wordsBetween) {
        List<String> newRelatedWords = new ArrayList<>();
        for (String related: relatedWords){
            for(String remaining: wordsBetween){
                if (hasOneCharDifference(related, remaining)) {
                    newRelatedWords.add(remaining);
                }
            }
        }
        return newRelatedWords;
    }

    private static boolean hasOneCharDifference(String left, String right) {
        byte[] leftBytes = left.getBytes();
        byte[] rightBytes = right.getBytes();
        boolean hasOneDifferentElement = false;
        if (leftBytes.length != rightBytes.length) return false;
        for (int i = 0; i < leftBytes.length; i++) {
            if (rightBytes[i] != leftBytes[i]) {
                if (hasOneDifferentElement) {
                    return false;
                }
                hasOneDifferentElement = true;
            }
        }
        return hasOneDifferentElement;
    }


}
