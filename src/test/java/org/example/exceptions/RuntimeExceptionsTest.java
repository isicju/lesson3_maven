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
                runtimeExceptions::throwsNullPointerException,
                "Had to thrown an exception but it didn't"
        );
    }

    @Test
    void arrayIndexOutOfBoundsTesting() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                runtimeExceptions::throwsArrayIndexOutOfBoundsException,
                "Had to thrown an exception but it didn't"
        );
    }

    @Test
    void numberFormatExceptionTesting() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                NumberFormatException.class,
                runtimeExceptions::throwsNumberFormatException,
                "Had to thrown an exception but it didn't"
        );
    }

    @Test
    void illegalArgumentExceptionTesting() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                IllegalArgumentException.class,
                runtimeExceptions::throwsIllegalArgumentException,
                "Had to thrown an exception but it didn't"
        );
    }

    @Test
    void classCastExceptionTesting() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                ClassCastException.class,
                () -> runtimeExceptions.throwsClassCastException(),
                "Had to thrown an exception but it didn't"
        );
    }


}
