package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorsTest extends DefaultTest {

    @Test
    void OutOfMemoryExceptionErrorTesting() {
        Errors error = new Errors();
        assertThrows(
                OutOfMemoryError.class,
                () -> error.throwsOOOException(),
                "Had to trow an exception but it didn't"
        );
    }
    @Test
    void stackOverFlowErrorTesting() {
        Errors error = new Errors();
        assertThrows(
                StackOverflowError.class,
                () -> error.throwsStackOverFlowError(),
                "Had to trow an exception but it didn't"
        );
    }
}
