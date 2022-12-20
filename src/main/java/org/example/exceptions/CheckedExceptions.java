package org.example.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedExceptions {

    public void throwsFileNotFoundTest() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File(""));
    }

}
