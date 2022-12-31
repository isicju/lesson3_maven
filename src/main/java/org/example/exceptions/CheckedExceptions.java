package org.example.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptions {

    public void throwsFileNotFoundTest() throws FileNotFoundException {
        File file = new File("wrong/path/to/file.txt");
        FileReader fr = new FileReader(file);
    }

}
