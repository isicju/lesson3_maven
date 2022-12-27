package org.example.algo;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MajorProblemTest extends DefaultTest {

    @Test
    public void oneRightAnswerTest() {
        int[] input = new int[]{1, 1, 2, 4, 5};
        int rightOutput = 1;
        assertEquals(MajorProblem.findMajorityElement(input), rightOutput);
    }
    @Test
    public void twoRightAnswersTest() {
        int[] input = new int[]{1, 1, 2, 2, 4, 5};
        int rightOutput = 1;
        assertEquals(MajorProblem.findMajorityElement(input), rightOutput);
    }
    @Test
    public void nullInArrayTest() {
        int[] input = new int[0];
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> MajorProblem.findMajorityElement(input),
                "Had to trow an exception but it didn't");
    }
    //cover all main scenarios

}
