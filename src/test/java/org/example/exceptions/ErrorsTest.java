package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorsTest extends DefaultTest {

    @Test
    void outOfMemoryErrorTesting() {
        Errors errors = new Errors();
        assertThrows(
                OutOfMemoryError.class,
                errors::throwsOOOException,
                "Had to thrown an error but it didn't"
        );
    }
    @Test
    void throwsStackOverFlowErrorTesting() {
        Errors errors = new Errors();
        assertThrows(
                StackOverflowError.class,
                errors::throwsStackOverFlowError,
                "Had to thrown an error but it didn't"
        );
    }
}
