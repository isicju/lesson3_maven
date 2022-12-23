package org.example.validators;

import com.google.gson.annotations.SerializedName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneValidationUtilsTest {

    @SerializedName("Testing for typical rus/KZ phone format 8981 (no brackets)")
    @Test
    void isCisNumber1() {
        assertTrue(PhoneValidationUtils.isCisNumber("79817862364"));
        assertTrue(PhoneValidationUtils.isCisNumber("798178652364"));
        assertTrue(PhoneValidationUtils.isCisNumber("898178652364"));

    }

    @SerializedName("Testing for typical ukranian phone format 380... (no brackets)")
    @Test
    void isCisNumber2() {
        assertTrue(PhoneValidationUtils.isCisNumber("3809825862364"));
    }

    @SerializedName("Testing for typical AZER phone format 994... (no brackets)")
    @Test
    void isCisNumber3() {
        assertTrue(PhoneValidationUtils.isCisNumber("9949815862364"));
    }

    @SerializedName("Testing for typical Estonian phone format 372... (no brackets)")
    @Test
    void isCisNumber4() {
        assertTrue(PhoneValidationUtils.isCisNumber("3727992222"));
    }

    @SerializedName("Testing englishPhone  +44 phone (no brackets)")
    @Test
    void isCisNumber5() {
        assertFalse(PhoneValidationUtils.isCisNumber("441515125125"));
    }
    @SerializedName("Testing NotNumber")
    @Test
    void isCisNumber6() {
        assertFalse(PhoneValidationUtils.isCisNumber("4gf121121"));
        assertFalse(PhoneValidationUtils.isCisNumber("1g1g1g121t12"));

    }


}