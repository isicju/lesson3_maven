package org.example.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CheckedExceptions {
    
    public static void throwsFileNotFoundTest() throws IOException {
        FileReader fileReader = new FileReader("error.txt");
    }
}