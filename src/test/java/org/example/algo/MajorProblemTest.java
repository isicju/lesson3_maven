package org.example.algo;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MajorProblemTest extends DefaultTest {

    MajorProblem majorProblem = new MajorProblem();

    @Test
    void mainTest() {
        int[] testArray1 = {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2}; // 2 встречается больше половины случаев
        int testTarget = majorProblem.findMajorityElement(testArray1);
        assertThat(2, equalTo(testTarget));

        int[] testArray2 = {4, 0, 5, 5, 4, 1, 2, 4, 3}; // 4 встречается меньше половины случаев, но чаще остальных
        testTarget = majorProblem.findMajorityElement(testArray2);
        assertThat(4, equalTo(testTarget));

        int[] testArray3 = {7, 8, 8, 7, 9}; // 8 встречается столько же, сколько и 7, выводится наибольшее число
        testTarget = majorProblem.findMajorityElement(testArray3);
        assertThat(8, equalTo(testTarget));

        int[] testArray4 = {1, 2, 3, 4, 9, 8, 7, 6}; // все встречаются по одному разу, выводится наибольшее число
        testTarget = majorProblem.findMajorityElement(testArray4);
        assertThat(9, equalTo(testTarget));
    }

    @Test
    void exceptionalCasesTest() {
        int[] testArray5 = null; // выбрасывается NullPointerException с сообщением в консоль
        majorProblem.findMajorityElement(testArray5);

        int[] testArray6 = {}; // выбрасывается IndexOutOfBoundsException с сообщением в консоль
        majorProblem.findMajorityElement(testArray6);
    }

}
