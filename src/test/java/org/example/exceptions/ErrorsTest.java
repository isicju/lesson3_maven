package org.example.exceptions;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ErrorsTest extends DefaultTest {

    @Test
    void exceptionTesting(){

        Errors errors = new Errors();

       /* assertThrows(
                OutOfMemoryError.class,
                ()-> errors.throwsOOOException(),
                "some text"
        );*/

        assertThrows(
                StackOverflowError.class,
                ()-> errors.throwsStackOverFlowError(),
                "some text"
        );
    }

}
