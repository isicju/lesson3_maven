package org.example;

import org.example.DefaultTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class StringValidationUtilsTest extends DefaultTest {

    @Test
    public void validPhone(){
        String validPhoneNumber = "76333427852";
        boolean isValidPhone = StringValidationUtils.isValidNumber(validPhoneNumber);
        assertThat(true, Matchers.equalTo(isValidPhone));
        validPhoneNumber = "+79681807732";
        isValidPhone = StringValidationUtils.isValidNumber(validPhoneNumber);
        assertThat(true, Matchers.equalTo(isValidPhone));
        validPhoneNumber = "+375(96)190-66-32";
        isValidPhone = StringValidationUtils.isValidNumber(validPhoneNumber);
        assertThat(true, Matchers.equalTo(isValidPhone));
    }

    @Test
    public void invalidPhone(){
        String invalidPhoneNumber = "+12384906354";
        boolean isValidPhone = StringValidationUtils.isValidNumber(invalidPhoneNumber);
        assertThat(false, Matchers.equalTo(isValidPhone));
        invalidPhoneNumber = "+(7922)593-64-22";
        isValidPhone = StringValidationUtils.isValidNumber(invalidPhoneNumber);
        assertThat(false, Matchers.equalTo(isValidPhone));
        invalidPhoneNumber = "996-215-934-86-13";
        isValidPhone = StringValidationUtils.isValidNumber(invalidPhoneNumber);
        assertThat(false, Matchers.equalTo(isValidPhone));
        invalidPhoneNumber = "";
        isValidPhone = StringValidationUtils.isValidNumber(invalidPhoneNumber);
        assertThat(false, Matchers.equalTo(isValidPhone));
    }

    @Test
    public void validEmail(){
        String validEmailAddress = "username@gmail.com";
        boolean isValidEmail = StringValidationUtils.isValidGmail(validEmailAddress);
        assertThat(true, Matchers.equalTo(isValidEmail));
        validEmailAddress = "user-name@gmail.com";
        isValidEmail = StringValidationUtils.isValidGmail(validEmailAddress);
        assertThat(true, Matchers.equalTo(isValidEmail));
        validEmailAddress = "user.name@gmail.com";
        isValidEmail = StringValidationUtils.isValidGmail(validEmailAddress);
        assertThat(true, Matchers.equalTo(isValidEmail));
    }

    @Test
    public void invalidEmail(){
        String invalidEmailAddress = "username-@gmail.com";
        boolean isValidEmail = StringValidationUtils.isValidGmail(invalidEmailAddress);
        assertThat(false, Matchers.equalTo(isValidEmail));
        invalidEmailAddress = ".username@gmail.com";
        isValidEmail = StringValidationUtils.isValidGmail(invalidEmailAddress);
        assertThat(false, Matchers.equalTo(isValidEmail));
        invalidEmailAddress = "username@yandex.ru";
        isValidEmail = StringValidationUtils.isValidGmail(invalidEmailAddress);
        assertThat(false, Matchers.equalTo(isValidEmail));
        invalidEmailAddress = "";
        isValidEmail = StringValidationUtils.isValidGmail(invalidEmailAddress);
        assertThat(false, Matchers.equalTo(isValidEmail));
    }

}
