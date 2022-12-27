package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RuntimeExceptionsTest extends DefaultTest {
    @Test
    void nullPointerExceptionTesting() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                NullPointerException.class,
                runtimeExceptions::throwsNullPointerException,
                "Had to trow an exception but it didn't"
        );
    }

    @Test
    void arrayIndexOutOfBoundsExceptionTesting() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                runtimeExceptions::throwsArrayIndexOutOfBoundsException,
                "Had to trow an exception but it didn't"
        );
    }

    @Test
    void numberFormatExceptionTesting() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                NumberFormatException.class,
                runtimeExceptions::throwsNumberFormatException,
                "Had to trow an exception but it didn't"
        );
    }

    @Test
    void illegalArgumentExceptionTesting() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                IllegalArgumentException.class,
                runtimeExceptions::throwsIllegalArgumentException,
                "Had to trow an exception but it didn't"
        );
    }

    @Test
    void classCastExceptionTesting() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                ClassCastException.class,
                () -> runtimeExceptions.throwsClassCastException(),
                "Had to trow an exception but it didn't"
        );
    }
}
