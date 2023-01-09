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
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> runtimeExceptions.throwsArrayIndexOutOfBoundsException(),
                "Had to trown an exception but it didn't"
        );

        assertThrows(
                NumberFormatException.class,
                () -> runtimeExceptions.throwsNumberFormatException(),
                "Had to trown an exception but it didn't"
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> runtimeExceptions.throwsIllegalArgumentException(),
                "Had to trown an exception but it didn't"
        );

        assertThrows(
                ClassCastException.class,
                () -> runtimeExceptions.throwsClassCastException(),
                "Had to trown an exception but it didn't"
        );
    }
}
