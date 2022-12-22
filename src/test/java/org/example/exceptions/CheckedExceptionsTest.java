package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;


public class CheckedExceptionsTest extends DefaultTest {
    CheckedExceptions checkedExceptions = new CheckedExceptions();

    @Test
    public void throwsFileNotFoundTest() {
        assertThrows(FileNotFoundException.class, checkedExceptions::throwsFileNotFoundTest);
    }

}
