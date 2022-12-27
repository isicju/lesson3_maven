package org.example.faang.online;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // N natural
        Integer[] myArray = new Integer[]{23, 33, 44, 1, 12}; //  O(1)
        //
        for (int i = 0; i < myArray.length - 1; i++) {
            for (int j = 0; j < myArray.length - 1; j++) {
                System.out.println(myArray[i] * myArray[j]);
            }
        }

        for (int i = 0; i < myArray.length - 1; i++) {
                System.out.println(myArray[i]);
        }

    }

}
