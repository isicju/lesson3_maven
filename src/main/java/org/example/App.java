package org.example;


public class App {

    // myChars.length -> N
    public String inverseString(String myChars) {
        byte[] myCharsByteArray = myChars.getBytes(); // N
        byte[] invertedByteArray = new byte[myCharsByteArray.length]; // C -> N
        for (int i = 0; i < myCharsByteArray.length; i++) {
            invertedByteArray[myCharsByteArray.length - i - 1] = myCharsByteArray[i]; // 10
        }

        return new String(invertedByteArray);
    }

    public boolean hasSum(int[] input, int sum) {
        for (int i = 0; i < input.length; i++) {
            int firstNum = input[i];
            for (int j = i + 1; j < input.length; j++) {
                int secondNum = input[j];
                if (firstNum + secondNum == sum) return true;
            }
        }
        return false;
    }

    public String helloWorld() {
        return "hello world";
    }

}
