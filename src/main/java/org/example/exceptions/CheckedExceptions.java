package org.example.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptions {

    public void throwsFileNotFoundException() throws IOException{ //файл не найден
        String file = "C:/server1.txt";
            try (FileReader input = new FileReader(file);
                 BufferedReader reader = new BufferedReader(input)) {
                while (reader.ready()) {
                    reader.read();
                }
            }
    }

}
