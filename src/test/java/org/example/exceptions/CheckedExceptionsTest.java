package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckedExceptionsTest extends DefaultTest {

    private CheckedExceptions checked;

    @BeforeAll
    public void init() {
        checked = new CheckedExceptions();
    }

    @Test
    void NullPointerTesting() {
        assertThrows(IOException.class,
                () -> checked.throwsFileNotFoundException(),
                "Had to trown an exception but it didn't"
        );
    }

}
