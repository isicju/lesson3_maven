package org.example.exceptions;

import java.io.*;

public class CheckedExceptions {

    public void throwsFileNotFound() throws IOException {
        File file = new File("C:\\noexistentfolder");
        FileInputStream fis = new FileInputStream(file);
    }
}