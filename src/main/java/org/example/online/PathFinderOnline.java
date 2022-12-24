package org.example.online;

import java.util.ArrayList;
import java.util.List;

public class PathFinderOnline {

    public static boolean hasPath(String head, String tail, List<String> wordsBetween) {
        validatePathInputs(head,tail,wordsBetween);
        List<String> relatedWords = new ArrayList<>();
        relatedWords.add(head);
        while (!hasConnectionWithTail(relatedWords, tail) && !relatedWords.isEmpty()) {
            relatedWords =  extractRelativeWords(relatedWords , wordsBetween);
            wordsBetween.removeAll(relatedWords);
        }
        return hasConnectionWithTail(relatedWords, tail);
    }

    private static void validatePathInputs(String head, String tail, List<String> wordsBetween){
        if(head == null || head.isEmpty()) throw new RuntimeException("head is null or empty");
        if(tail == null || tail.isEmpty()) throw new RuntimeException("tail is null or empty");
        if (wordsBetween == null || wordsBetween.isEmpty()) throw new RuntimeException("words between is null or empty");
    }

    public static boolean hasConnectionWithTail(List<String> relatedWords, String tail){
        for (String relatedWord: relatedWords){
            if (hasOnlyOneCharDifference(relatedWord, tail)) return true;
        }
        return false;
    }

    public static List<String> extractRelativeWords(List<String> relatedWords, List<String> wordsBetween) {
        List<String> futureRelated = new ArrayList<>();
        for (String relatedWord : relatedWords) {
            for (String wordBetween : wordsBetween) {
                if (hasOnlyOneCharDifference(relatedWord, wordBetween)){
                    futureRelated.add(wordBetween);
                }
            }
        }
        return futureRelated;
    }


    private static boolean hasOnlyOneCharDifference(String left, String right) {
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
