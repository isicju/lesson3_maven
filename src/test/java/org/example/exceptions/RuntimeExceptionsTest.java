package org.example.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RuntimeExceptionsTest {

    @DisplayName("nullPointerTest: null.length()")
    @Test
    void nullPointerTest() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();

        assertThrows(
                NullPointerException.class,
                runtimeExceptions::throwsNullPointerException,
                "Expected throwsNullPointerException() to throw, but it didn't"
        );
    }

    @DisplayName("indexOutOfBoundTest: Getting element from list with index > length")
    @Test
    void indexOutOfBoundTest() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();

        assertThrows(
                IndexOutOfBoundsException.class,
                runtimeExceptions::throwsArrayIndexOutOfBoundsException,
                "Expected, throwsArrayIndexOutOfBoundsException() to throw, but it didn't"
        );

    }

    @DisplayName("numberFormatTest: Testing bad-verified business-logic with bad inputs")
    @Test
    void numberFormatTest() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();

        assertThrows(
                NumberFormatException.class, () ->
                        runtimeExceptions.saveFavouriteNumber("seven"),
                "Expected, saveFavouriteNumber() to throw, but it didn't"
        );
    }

    @DisplayName("illegalArgumentTest: Verifying business-logic with null inputs")
    @Test
    void illegalArgumentTest() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();

        assertThrows(
                IllegalArgumentException.class, () ->
                        runtimeExceptions.processSomethingNotNull(null),
                "Expected, saveFavouriteNumber() to throw, but it didn't"
        );

    }
    @DisplayName("classCastException: Verifying business-logic with not-integer inputs while number expected")
    @Test
    void classCastTest() {
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();

        assertThrows(
                ClassCastException.class, () ->
                        runtimeExceptions.saveFavouriteNumber2("7"),
                "Expected, saveFavouriteNumber2() to throw, but it didn't"
        );

    }


}
