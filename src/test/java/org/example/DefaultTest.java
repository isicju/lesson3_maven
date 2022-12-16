package org.example;

import org.example.service.SmsNotificationService;
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
    @Test
    public void validNumber() {
        boolean isValidNumber = SmsNotificationService.SmsBody.isValidNumber("89119629732");
        if (!isValidNumber) {
            throw new RuntimeException("phone has invalid format!");
        }
    }

    @Test
    public void validEmail() {
        boolean isValidEmail = StringValidationUtils.isValidEmail("fonova@mail.com");
        if (!isValidEmail) {
            throw new RuntimeException("email has invalid format!");
        }
    }

    @Test
    public void sortBubble() {
        App app = new App();
        int[] array = new int[] {4, 2, 1, 6, 5};
        int[] invertedArray = app.bubbleSort(array);
        assertThat(invertedArray, equalTo(new int[]{1, 2, 4, 5, 6}));
    }

    @Test
    public void validMobileNumber() {
        boolean isValidMobileNumber = StringValidationUtils.validMobileNumber("8(911)940-30-11");
        if (!isValidMobileNumber) {
            throw new RuntimeException("phone has invalid format!");
        }
    }

}
