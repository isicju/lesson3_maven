package org.example.exceptions;

import java.io.*;

public class CheckedExceptions {

    public void throwsFileNotFound() {
        try {
            File file = new File("C:\\noexistentfolder");
            FileInputStream fis = new FileInputStream(file);
            fis.read();
        }
        catch (IOException e) {
            System.out.println("No file to read!");
        }
    }

}
