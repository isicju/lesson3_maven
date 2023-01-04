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
    @Test
    void throwsArrayIndexOutOfBoundsException() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> runtimeExceptions.throwsArrayIndexOutOfBoundsException(),
                "Had to trown an ArrayIndexOutOfBoundsException exception but it didn't"
        );
    }
    @Test
    void throwsNumberFormatException() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                NumberFormatException.class,
                () -> runtimeExceptions.throwsNumberFormatException(),
                "Had to trown an NumberFormatException exception but it didn't"
        );
    }
    @Test
    void throwsIllegalArgumentException() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                IllegalArgumentException.class,
                () -> runtimeExceptions.throwsIllegalArgumentException(),
                "Had to trown an IllegalArgumentException exception but it didn't"
        );
    }
    @Test
    void throwsClassCastException() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                ClassCastException.class,
                () -> runtimeExceptions.throwsClassCastException(),
                "Had to trown an IClassCastException exception but it didn't"
        );
    }
}
