package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorsTest extends DefaultTest {
    Errors errors = new Errors();

    @Test
    public void testThrowsOOOException() {
        assertThrows(OutOfMemoryError.class, errors::throwsOOOException);
    }

    @Test
    public void testThrowsStackOverFlowError() {
        assertThrows(StackOverflowError.class, errors::throwsStackOverFlowError);

    }
}

