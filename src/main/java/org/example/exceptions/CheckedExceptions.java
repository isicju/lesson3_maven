package org.example.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptions {

    public static void throwsFileNotFoundException() {
        String file = "file.txt";
        try {
            try (FileReader input = new FileReader(file);
                 BufferedReader reader = new BufferedReader(input)) {
                while (reader.ready()) {
                    System.out.println(reader.read());
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
        }
    }

}
