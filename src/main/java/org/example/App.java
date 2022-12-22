package org.example;


public class App {

//    public static boolean hasConnection(String head, String tail, String[] words) {
//        String current = head;
//        for (String nextCurrent : words) {
//            if (!findWords(current, nextCurrent)) {
//                break;
//            }
//            current = nextCurrent;
//            System.out.println(findWords(current, nextCurrent));
//        }
//
//        return findWords(current, tail);
//    }
//
//    public static boolean findWords(String leftWord, String rightWord) {
//        char[] leftArray = leftWord.toCharArray();
//        char[] rightArray = rightWord.toCharArray();
//        int diffCount = 0;
//        for (int i = 0; i < leftWord.length(); i++) {
//            if (leftArray[i] != rightArray[i]) {
//                diffCount = diffCount + 1;
//            }
//        }
//        return diffCount == 1;
//    }















//    // myChars.length -> N
//    public String inverseString(String myChars) {
//        byte[] myCharsByteArray = myChars.getBytes(); // N
//        byte[] invertedByteArray = new byte[myCharsByteArray.length]; // C -> N
//        for (int i = 0; i < myCharsByteArray.length; i++) {
//            invertedByteArray[myCharsByteArray.length - i - 1] = myCharsByteArray[i]; // 10
//        }
//
//        return new String(invertedByteArray);
//    }
//
//    public boolean hasSum(int[] input, int sum) {
//        for (int i = 0; i < input.length; i++) {
//            int firstNum = input[i];
//            for (int j = i + 1; j < input.length; j++) {
//                int secondNum = input[j];
//                if (firstNum + secondNum == sum) return true;
//            }
//        }
//        return false;
//    }
//
//    public String helloWorld() {
//        return "hello world";
//    }

}
