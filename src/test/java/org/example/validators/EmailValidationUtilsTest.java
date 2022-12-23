package org.example.validators;

import com.google.gson.annotations.SerializedName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidationUtilsTest {

    @SerializedName("Testing right gmail")
    @Test
    void isGmail1() {
        assertFalse(EmailValidationUtils.isGmail("a.agaw@gmail.com"));
        assertFalse(EmailValidationUtils.isGmail("ramrush.r@gmail.com"));

    }

    @SerializedName("Testing wrong gmail")
    @Test
    void isGmail2() {
        assertFalse(EmailValidationUtils.isGmail("arrarw@mail.ru"));
        assertFalse(EmailValidationUtils.isGmail("arrarwgagaga"));
        assertFalse(EmailValidationUtils.isGmail("arrarw@gmail.ru"));
    }
}
