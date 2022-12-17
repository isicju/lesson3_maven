package org.example.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RuntimeExceptionsTest {

    @Test
    void exceptionTesting() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();

        RuntimeException thrown = assertThrows(
                NullPointerException.class,
                () -> runtimeExceptions.throwsNullPointerException(),
                "Expected doThing() to throw, but it didn't"
        );

//        assertTrue(thrown.getMessage().contentEquals("Runtime"));
    }


}
