package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RuntimeExceptionsTest extends DefaultTest {
    RuntimeExceptions runtimeExceptions = new RuntimeExceptions();

    @Test
    public void testThrowsNullPointerException() {
        assertThrows(NullPointerException.class, runtimeExceptions::throwsNullPointerException);
    }

    @Test
    public void testThrowsArrayIndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, runtimeExceptions::throwsArrayIndexOutOfBoundsException);
    }

    @Test
    public void testThrowsNumberFormatException() {
        assertThrows(NumberFormatException.class, runtimeExceptions::throwsNumberFormatException);
    }

    @Test
    public void testThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, runtimeExceptions::throwsIllegalArgumentException);
    }

}
