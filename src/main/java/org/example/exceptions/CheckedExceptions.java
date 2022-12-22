package org.example.exceptions;

import java.io.*;

public class CheckedExceptions {

    public void throwsFileNotFoundTest() throws FileNotFoundException {
        FileReader reader = new FileReader("test.txt");
    }
}
