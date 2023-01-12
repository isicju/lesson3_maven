package org.example.algo;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class MajorProblemTest extends DefaultTest {

    @Test
    void exceptionTesting()
    {
        MajorProblem majorProblem = new MajorProblem();
        int[] x = null;
        int[] y = {};
        int[] z = {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
        int[] v = {1, 3, 1, 1};

        assertThrows(
                NullPointerException.class,
                ()->majorProblem.findMajorElement(x),
                "nullpointerexception"
        );

        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                ()->majorProblem.findMajorElement(y),
                "ArrayIndexOutOfBoundsException"
        );

        assertEquals(2, majorProblem.findMajorElement(z));
        assertEquals(1, majorProblem.findMajorElement(v));
    }

}
