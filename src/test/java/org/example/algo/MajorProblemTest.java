package org.example.algo;

import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MajorProblemTest extends DefaultTest {
    @Test
    public void findMajorityElementTest() {
        MajorProblem majorProblem = new MajorProblem();
        int[] arrayOfNumbers = {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
        Assertions.assertEquals(2, majorProblem.findMajorityElement(arrayOfNumbers));
    }

    @Test
    public void didntFindMajorityElementTest() {
        MajorProblem majorProblem = new MajorProblem();
        int[] arrayOfNumbers = {1, 3, 1, 1};
        Assertions.assertEquals(1, majorProblem.findMajorityElement(arrayOfNumbers));
    }
}
