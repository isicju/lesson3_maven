package org.example.exceptions;

import java.io.*;

public class CheckedExceptions {

    public void throwsFileNotFound() throws IOException {
        File file = new File("C:\\noexistentfolder");
        try {
            FileInputStream fis = new FileInputStream(file);
            fis.read();
        }
        catch (FileNotFoundException e) {
            System.out.println("No file to read!");
        }
    }
}
