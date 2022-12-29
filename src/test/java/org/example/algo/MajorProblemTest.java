package org.example.algo;

import org.example.DefaultTest;
import org.example.exceptions.RuntimeExceptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MajorProblemTest extends DefaultTest {

    //cover all main scenarios
    @Test
    void checkFindMajorityValueLongArray(){
        MajorProblem majorProblem = new MajorProblem();
        Assertions.assertEquals(7, majorProblem.findMajorityElement(new int [] {2, 7, 7, 2, 7, 7, 2, 3, 7, 5, 2}));
    }
    @Test
    void checkFindMajorityValueSmallArray(){
        MajorProblem majorProblem = new MajorProblem();
        Assertions.assertEquals(1, majorProblem.findMajorityElement(new int [] {1, 3, 1, 1}));
    }
    @Test
    void checkFindMajorityNegativeValue(){
        MajorProblem majorProblem = new MajorProblem();
        Assertions.assertEquals(-1, majorProblem.findMajorityElement(new int [] {-1, 3, -1, 1}));
    }
    @Test
    void checkNullPointExceptionInArray() {
        MajorProblem majorProblem = new MajorProblem();

        assertThrows(
                NullPointerException.class,
                () -> majorProblem.findMajorityElement(null),
                "array is null!"
        );
    }

}
