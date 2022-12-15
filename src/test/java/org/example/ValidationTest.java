package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationTest extends DefaultTest {


    @Test
    public void validEmailAddress() {
        Assertions.assertTrue(StringValidationUtils.isValidEmail("alexanderLOS1337@gmail.com"));
        Assertions.assertTrue(StringValidationUtils.isValidEmail("artem_6bIk@gmail.com"));
    }

    @Test
    public void invalidEmailAddress() {
        Assertions.assertFalse(StringValidationUtils.isValidEmail("kekarini@yandex.ru"));
        Assertions.assertFalse(StringValidationUtils.isValidEmail("abcdedg^2@gmail.com"));
    }

    @Test
    public void validPhoneNumber() {
        Assertions.assertTrue(StringValidationUtils.isValidPhone("+3801234567890"));
        Assertions.assertTrue(StringValidationUtils.isValidPhone("7-123-456-78-90"));
        Assertions.assertTrue(StringValidationUtils.isValidPhone("+7(123)7652382"));
    }

    @Test
    public void invalidPhoneNumber() {
        Assertions.assertFalse(StringValidationUtils.isValidPhone("+12345678901"));
        Assertions.assertFalse(StringValidationUtils.isValidPhone("+7i234567890"));
    }

    @Test
    public void validPhoneRegion() {
        Assertions.assertTrue(StringValidationUtils.isValidPhone("+3801234567890"));
        Assertions.assertTrue(StringValidationUtils.isValidPhone("71234567890"));
        Assertions.assertTrue(StringValidationUtils.isValidPhone("+9981237652382"));
    }

    @Test
    public void invalidPhoneRegion() {
        Assertions.assertFalse(StringValidationUtils.isValidPhone("+12345678901"));
        Assertions.assertFalse(StringValidationUtils.isValidPhone("151234567890"));
        Assertions.assertFalse(StringValidationUtils.isValidPhone("9991234567890"));
    }


}
