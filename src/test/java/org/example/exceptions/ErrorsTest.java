package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorsTest extends DefaultTest {

    @Test
    void errorTesting() {
        Errors errors = new Errors();
        assertThrows(
                OutOfMemoryError.class,
                () -> errors.throwsOutOfMemoryError(),
                "Expected throwsOutOfMemoryError() to throw an error, but it didn't"
        );
        assertThrows(
                StackOverflowError.class,
                () -> errors.throwsStackOverFlowError(),
                "Expected throwsStackOverFlowError() to throw an error, but it didn't"
        );
    }

}
