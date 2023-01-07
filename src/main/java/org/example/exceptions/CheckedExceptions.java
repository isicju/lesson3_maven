package org.example.exceptions;

import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptions {

    public void throwsFileNotFoundTest() throws IOException {
        String filePath = " ";
        FileReader reader = new FileReader(filePath);
        reader.read();
    }

}
