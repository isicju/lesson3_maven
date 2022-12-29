package org.example.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CheckedExceptions {

    public void throwsFileNotFoundTest() throws FileNotFoundException {
        FileReader fileReader = new FileReader("FileIsNotExist.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
    }

}
