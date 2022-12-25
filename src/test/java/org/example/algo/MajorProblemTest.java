package org.example.algo;

import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MajorProblemTest extends DefaultTest {

    @DisplayName("Testing algorithm for classic case")
    @Test
    public void majorProblemTest1(){
        int[] array = {2, 8, 7, 2,5125, 2, 5, 2, 3, 1, 2, 2,22,552,-12521, -512512, -22, 12};
        int b = MajorProblem.findMajorityElement(array);
        Assertions.assertEquals(2,b);
    }
    @DisplayName("Testing algorithm for case with one number array")
    @Test
    public void majorProblemTest2(){
        int[] array = {55};
        int b = MajorProblem.findMajorityElement(array);
        Assertions.assertEquals(55,b);
    }

    @DisplayName("Testing algorithm with empty array")
    @Test
    public void majorProblemTest3(){
        int[] array = {};
        int b = MajorProblem.findMajorityElement(array);
        Assertions.assertEquals(0,b);
    }


}
