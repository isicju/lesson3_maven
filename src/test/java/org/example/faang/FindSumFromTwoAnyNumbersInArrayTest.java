package org.example.faang;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.example.faang.SumFromTwoNumbers.hasSum;
import static org.example.faang.online.FindSumFromTwoAnyNumbersInArray.hasSumOnline;
import static org.example.faang.online.FindSumFromTwoAnyNumbersInArray.hasSumOnlineUsing;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FindSumFromTwoAnyNumbersInArrayTest extends DefaultTest {

    @Test
    public void positiveSum(){
        assertTrue(hasSumOnline(new int[]{11,3,44,123,7}, 18));
        assertTrue(hasSumOnlineUsing(new int[]{11,3,44,123,7}, 18));
    }

    @Test
    public void negativeSum(){
        assertFalse(hasSumOnline(new int[]{11,3,44,123,7}, 19));
        assertFalse(hasSumOnlineUsing(new int[]{11,3,44,123,7}, 19));
    }

}
