package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckedExceptionsTest extends DefaultTest {

    private CheckedExceptions checkedExceptions;

    @Test
    @DisplayName("Test check that method throws FileNotFoundException")
    public void exceptionTestingFileNotFoundException() {
        checkedExceptions = new CheckedExceptions();
        assertThrows(
                FileNotFoundException.class,
                () -> checkedExceptions.throwsFileNotFoundTest(),
                "Had to trows an FileNotFoundException but it didn't"
        );
    }
}
