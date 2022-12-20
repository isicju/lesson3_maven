package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorsTest extends DefaultTest {

    private Errors errors;

    @Test
    @DisplayName("Test check that method throws OutOfMemoryError with list")
    public void throwsOOOE() {
        errors = new Errors();
        assertThrows(
                OutOfMemoryError.class,
                () -> errors.throwsOOOException());
    }

    @Test
    @DisplayName("Test check that method throws OutOfMemoryError with Array")
    public void throwsOOOEWithArray() {
        errors = new Errors();
        assertThrows(
                OutOfMemoryError.class,
                () -> errors.throwsOOOExceptionWithArray());
    }

    @Test
    @DisplayName("Test check that method throws OutOfMemoryError with HashMap")
    public void throwsOOOEWithHashMap() {
        errors = new Errors();
        assertThrows(
                OutOfMemoryError.class,
                () -> errors.throwsOOOExceptionWithHashMap());
    }

    @Test
    @DisplayName("Test check that method throws StackOverFlowError")
    public void throwsSOFE() {
        errors = new Errors();
        assertThrows(
                StackOverflowError.class,
                () -> errors.throwsStackOverFlowError());
    }

}
