package org.example.algo;

import org.example.DefaultTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MajorProblemTest extends DefaultTest {

    private MajorProblem majorProblem;

    @Test
    @DisplayName("Test checks that method throws NullPointerException if array is null")
    public void throwsNullPointerException() {
        majorProblem = new MajorProblem();
        assertThrows(
                NullPointerException.class,
                () -> majorProblem.findMajorityElement(null));
    }

    @Test
    @DisplayName("Test check that method return 2")
    public void validReturnPositiveInt() {
        majorProblem = new MajorProblem();
        int expected = 2;
        int[] exampleArray = new int[]{2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2};
        assertEquals(expected, majorProblem.findMajorityElement(exampleArray));
    }

    @Test
    @DisplayName("Test check that method return -2")
    public void validReturnNegativeInt() {
        majorProblem = new MajorProblem();
        int expected = -2;
        int[] exampleArray = new int[]{-2, 8, 7, -2, 2, 5, -2, 3, 2, -2, 2};
        assertEquals(expected, majorProblem.findMajorityElement(exampleArray));
    }

    @Test
    @DisplayName("Test check that method with small array return 1")
    public void validReturnOneWithSmallArray() {
        majorProblem = new MajorProblem();
        int expected = 1;
        int[] exampleArray = new int[]{1, 3, 1, 1};
        assertEquals(expected, majorProblem.findMajorityElement(exampleArray));
    }

    @Test
    @DisplayName("Test check that method with small array return -1")
    public void validReturnNegativeOneWithSmallArray() {
        majorProblem = new MajorProblem();
        int expected = -1;
        int[] exampleArray = new int[]{1, 3, -1, -1};
        assertEquals(expected, majorProblem.findMajorityElement(exampleArray));
    }
}
