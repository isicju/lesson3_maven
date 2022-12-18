package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RuntimeExceptionsTest extends DefaultTest {
    @Test
    void exceptionTesting() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                NullPointerException.class,
                () -> runtimeExceptions.throwsNullPointerException(),
                "Had to trown an exception but it didn't"
        );
    }
}
