package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DefaultTest {


    @Test
    public void inverseString() {
        App app = new App();
        String inputString = "hello";
        String invertedString = app.inverseString(inputString);
        assertThat(invertedString, equalTo("olleh"));
    }

/*
    @Test
    public void checkHasSumPositive() {
        App app = new App();
        Assertions.assertTrue(positiveMatch.getFirstNum() == 3);
        Assertions.assertTrue(positiveMatch.getSecondNum() == 4);
    }

    @Test
    public void checkHasSumNegative() {
        App app = new App();
        App.Match negativeMatch = app.hasSum(new int[]{1, 3, 4, 11}, 70);
        Assertions.assertEquals(App.NO_MATCHES, negativeMatch);
    }*/


    //  // Homework 4 Test BubbleSort
    @Test
    public void BubbleSort() {
        App app = new App();
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] sortedArray = App.BubbleSort(array);
        assertThat(sortedArray, equalTo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
