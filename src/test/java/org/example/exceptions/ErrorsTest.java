package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorsTest extends DefaultTest {

    private Errors errors;

    @BeforeAll
    public void init() {
        errors = new Errors();
    }

    @Test
    void OOOExceptionTesting() {
        assertThrows(OutOfMemoryError.class,
                () -> errors.throwsOOOException(),
                "Had to trown an exception but it didn't"
        );
    }

    @Test
    void StackOverFlowErrorTesting() {
        assertThrows(StackOverflowError.class,
                () -> errors.throwsStackOverFlowError(),
                "Had to trown an exception but it didn't"
        );
    }

}
