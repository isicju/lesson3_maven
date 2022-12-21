package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RuntimeExceptionsTest extends DefaultTest {

    private RuntimeExceptions runtimeExceptions;

    @BeforeAll
    public void init() {
        runtimeExceptions = new RuntimeExceptions();
    }

    @Test
    void NullPointerTesting() {
        assertThrows(NullPointerException.class,
                () -> runtimeExceptions.throwsNullPointerException(),
                "Had to trown an exception but it didn't"
        );
    }

    @Test
    void ArrayIndexOutOfBoundsTesting() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> runtimeExceptions.throwsArrayIndexOutOfBoundsException(),
                "Had to trown an exception but it didn't"
        );
    }

    @Test
    void NumberFormatTesting() {
        assertThrows(NumberFormatException.class,
                () -> runtimeExceptions.throwsNumberFormatException(),
                "Had to trown an exception but it didn't"
        );
    }

    @Test
    void IllegalArgumentTesting() {  //НЕ РАБОТАЕТ С КОНСОЛЬЮ
        assertThrows(IllegalArgumentException.class,
                () -> runtimeExceptions.throwsIllegalArgumentException(),
                "Had to trown an exception but it didn't"
        );
    }

    @Test
    void ClassCastTesting() {
        assertThrows(ClassCastException.class,
                () -> runtimeExceptions.throwsClassCastException(),
                "Had to trown an exception but it didn't"
        );
    }

}
