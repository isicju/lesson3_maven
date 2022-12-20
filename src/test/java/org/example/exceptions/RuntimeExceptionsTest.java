package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RuntimeExceptionsTest extends DefaultTest {

    private RuntimeExceptions runtimeExceptions;

    @Test
    @DisplayName("Test check that method throws NullPointerException")
    public void exceptionTestingNullPointerException() {
        runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                NullPointerException.class,
                () -> runtimeExceptions.throwsNullPointerException(),
                "Had to trows an NullPointerException but it didn't"
        );
    }

    @Test
    @DisplayName("Test check that method throws ArrayIndexOutOfBoundsExceptions")
    public void exceptionTestingArrayIndexOutOfBoundsException() {
        runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> runtimeExceptions.throwsArrayIndexOutOfBoundsException(),
                "Had to trows an ArrayIndexOutOfBoundsException but it didn't"
        );
    }

    @Test
    @DisplayName("Test check that method throws NumberFormatException")
    public void exceptionTestingNumberFormatException() {
        runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                NumberFormatException.class,
                () -> runtimeExceptions.throwsNumberFormatException(),
                "Had to trows an NumberFormatException but it didn't"
        );
    }

    @Test
    @DisplayName("Test check that method throws IllegalArgumentException")
    public void exceptionTestingIllegalArgumentException() {
        runtimeExceptions = new RuntimeExceptions();
        assertThrows(
                IllegalArgumentException.class,
                () -> runtimeExceptions.throwsIllegalArgumentException(),
                "Had to trows an IllegalArgumentException but it didn't"
        );
    }

    @Test
    @DisplayName("Test check that method throws ClassCastException")
    public void exceptionTestingClassCastException() {
        assertThrows(
                ClassCastException.class,
                RuntimeExceptions::throwsClassCastException,
                "Had to trows an ClassCastException but it didn't"
        );
    }
}
