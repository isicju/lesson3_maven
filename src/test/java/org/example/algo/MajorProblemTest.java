package org.example.algo;

import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MajorProblemTest extends DefaultTest {
    
    @Test
    void testMajorProblemNormal() {
        MajorProblem majorProblem = new MajorProblem();
        Assertions.assertEquals(2, majorProblem.findMajorityElement(new int[]{2, 7, 7, 2, 7, 7, 2, 3, 7, 5, 2}));
    }
    
    @Test
    void testMajorProblemWithoutRepetition() {
        MajorProblem majorProblem = new MajorProblem();
        Assertions.assertEquals(0, majorProblem.findMajorityElement(new int[]{1, 2, 4, 3, 6, 5, 8, 7, 9, 0, 11}));
    }
    @Test
    void testMajorProblem() {
        MajorProblem majorProblem = new MajorProblem();
        assertThrows(
                NullPointerException.class,
                () -> majorProblem.findMajorityElement(null),
                "Problem"
        );
    }
    @Test
    void testMajorProblemWithoutEmpty() {
        MajorProblem majorProblem = new MajorProblem();
        Assertions.assertEquals(0, majorProblem.findMajorityElement(new int[]{}));
    }
}

