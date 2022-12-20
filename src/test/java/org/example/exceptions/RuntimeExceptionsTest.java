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
                "Expected throwsNullPointerException() to throw an exception, but it didn't"
        );
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> runtimeExceptions.throwsArrayIndexOutOfBoundsException(),
                "Expected throwsArrayIndexOutOfBoundsException() to throw an exception, but it didn't"
        );
        assertThrows(
                NumberFormatException.class,
                () -> runtimeExceptions.throwsNumberFormatException(),
                "Expected throwsNumberFormatException() to throw an exception, but it didn't"
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> runtimeExceptions.throwsIllegalArgumentException(),
                "Expected throwsIllegalArgumentException() to throw an exception, but it didn't"
        );
        assertThrows(
                ClassCastException.class,
                () -> runtimeExceptions.throwsClassCastException(),
                "Expected throwsClassCastException() to throw an exception, but it didn't"
        );
    }
}
