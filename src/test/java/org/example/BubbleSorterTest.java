package org.example;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class BubbleSorterTest extends DefaultTest {

    BubbleSorter bubbleSorter = new BubbleSorter();

    @Test
    void array() {
        int[] testArray = {9, 2, 4, 7, 5};
        int[] testSortedArray = bubbleSorter.bubbleSort(testArray);
        assertThat(new int[]{2, 4, 5, 7, 9}, equalTo(testSortedArray));
    }

}

