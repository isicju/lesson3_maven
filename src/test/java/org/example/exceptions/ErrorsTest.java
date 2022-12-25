package org.example.exceptions;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ErrorsTest {

    @DisplayName("ShutDown: should throw an Error")
    @Test()
    void serverUnderAttack() {
        assertThrows(
                Error.class,() ->  Errors.shutDown("HelloWorld"),
                "Expected, shutDown() to throw Error, but it didn't"
        );


    }
}

