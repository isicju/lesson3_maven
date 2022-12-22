package org.example.algo;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MajorProblemTest extends DefaultTest {

    @Test
    void testFindMajorityElement() {
        assertEquals(2, MajorProblem.findMajorityElement(new int[]{2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2}));
        assertEquals(1, MajorProblem.findMajorityElement(new int[]{1, 3, 1, 1}));
    }

    @Test
    public void testfindMajorityElement2() {

        assertThrows(IllegalArgumentException.class, () -> {
                    int[] array = new int[]{};
                    MajorProblem.findMajorityElement(array);
                }
        );

        assertThrows(IllegalArgumentException.class, () -> {
                    int[] array = new int[]{0, 1, 2, 8, 8, 8, 8, 9, 9, 9, 9};
                    MajorProblem.findMajorityElement(array);
                }
        );
    }
}
