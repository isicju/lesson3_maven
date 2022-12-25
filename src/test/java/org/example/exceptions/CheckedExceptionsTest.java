package org.example.exceptions;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.UncheckedIOException;

import static org.junit.jupiter.api.Assertions.*;

public class CheckedExceptionsTest {

    @DisplayName("Testing valid file path")
    @Test()
    public void ReadingExistingFile() {
        String path = "src/main/java/org/example/resources/myPerformance.txt";
        CheckedExceptions.readFile(path);
        assertDoesNotThrow(() -> CheckedExceptions.readFile(path),
                "Expected readFile not to throw any exceptions or errors");

    }
    @DisplayName("Testing invalid file path")
    @Test()
    public void ThrowsIOException() {
        String path = "src/main/java/org/example/resources/myPerformance2.txt";

        Exception exception = assertThrows(UncheckedIOException.class, ()
                -> CheckedExceptions.readFile(path));
        String expectedMessage = "FileNotFoundException";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }


}
