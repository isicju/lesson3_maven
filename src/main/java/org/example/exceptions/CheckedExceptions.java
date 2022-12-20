package org.example.exceptions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptions {

    public void throwsFileNotFoundTest() throws IOException {
        File file = new File("c:\\java\\emptyfolder\\testfile.txt");
        FileReader fileReader = new FileReader(file);
        int i;
        while ((i = fileReader.read()) != -1) {
            System.out.print((char) i);
        }
    }

}
