package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorsTest extends DefaultTest {
    @Test
    void throwsOOOException() {
        Errors memoryErrors = new Errors();
        assertThrows(
                OutOfMemoryError.class,
                () -> memoryErrors.throwsOOOException(),
                "Had to trown an OutOfMemoryError exception but it didn't"
        );
    }
    @Test
    void throwsStackOverFlowError() {
        Errors memoryErrors = new Errors();
        assertThrows(
                StackOverflowError.class,
                () -> memoryErrors.throwsStackOverFlowError(),
                "Had to trown an StackOverflowError exception but it didn't"
        );
    }
    
}
