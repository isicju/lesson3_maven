package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorsTest extends DefaultTest {
    @Test
    void checkthrowsOOOException(){
        Errors errorsTest = new Errors();
        assertThrows(OutOfMemoryError.class, () -> errorsTest.throwsOOOException(), "memory is full!");
    }

    @Test
    void checkthrowsStackOverFlowException(){
        Errors errorsTest = new Errors();
        assertThrows(StackOverflowError.class, () -> errorsTest.throwsStackOverFlowError(), "stack is full!");
    }



}
