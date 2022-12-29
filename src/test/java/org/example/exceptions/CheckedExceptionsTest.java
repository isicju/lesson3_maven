package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckedExceptionsTest extends DefaultTest {

    @Test
    public void throwsFileNotFoundTest() {
        CheckedExceptions checkedExceptions = new CheckedExceptions();
        assertThrows(FileNotFoundException.class, () -> checkedExceptions.throwsFileNotFoundTest(), "file not exist");
    }

}
