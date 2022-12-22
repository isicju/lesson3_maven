package org.example.algo;

import org.example.DefaultTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.example.algo.MajorProblem.findMajorityElement;
import static org.junit.jupiter.api.Assertions.*;

public class MajorProblemTest extends DefaultTest {

    private MajorProblem mj;

    @BeforeAll
    public void init() {
        mj = new MajorProblem();
    }

    @Test
    void IllegalArgumentExceptionTesting() {
        assertThrows(IllegalArgumentException.class,
                () -> findMajorityElement(new int[]{2, -5, 2, 3, 1, 2, 2}),
                "Had to trown an exception but it didn't"
        );
    }

    @Test
    void TestCorrectDataEntry() {
        assertEquals(1, findMajorityElement(new int[]{1, 3, 1, 1}));
    }

    @Test
    void TestIncorrectDataEntry() {
        assertNotEquals(2, findMajorityElement(new int[]{2, 3, 1, 1, 4, 5}));
    }

}
