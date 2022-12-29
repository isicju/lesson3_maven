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

    //Homework part 1.

    @Test
    void checkArrayIndexOutOfBoundsException(){
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> runtimeExceptions.throwsArrayIndexOutOfBoundsException(), "index does not exist!");
    }
    @Test
    void checkNumberFormatException(){
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(NumberFormatException.class, () -> runtimeExceptions.throwsNumberFormatException(), "format does not parsing!");
    }
    @Test
    void checkIllegalArgumentException(){
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(IllegalArgumentException.class, () -> runtimeExceptions.throwsIllegalArgumentException(), "format is invalid!");
    }
    @Test
    void checkClassCastException(){
        RuntimeExceptions runtimeExceptions = new RuntimeExceptions();
        assertThrows(ClassCastException.class, () -> runtimeExceptions.throwsClassCastException(), "Integer is not child from String");
    }
}
