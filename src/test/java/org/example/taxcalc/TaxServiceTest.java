package org.example.taxcalc;

import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TaxServiceTest extends DefaultTest {

    TaxService taxService;

    @BeforeEach
    public void init() {
        taxService = new TaxService();
    }

    @DisplayName("Verifying net salary for US citizen with 12 month of work")
    @Test
    public void simpleTest() {
        User validUserFromUS = new User(Region.US, "John Smith", 123000, 12);
        float valueAfterTax = taxService.calculateYearIncome(validUserFromUS);
        Assertions.assertEquals(valueAfterTax, 100860.0f);
    }
    @DisplayName("Verifying net salary for > 12 MONTH_OF_WORK US citizen")
    @Test
    public void basicTest1() {
        User validUserFromUS = new User(Region.US, "John Smith", 123000.00f, 14);
        float valueAfterTax = taxService.calculateYearIncome(validUserFromUS);
        Assertions.assertEquals(valueAfterTax, 117670.0f);
    }
    @DisplayName("Verifying net salary for NO_INCOME US citizen with 12 month of work")
    @Test
    public void basicTest2() {
        User validUserFromUS = new User(Region.US, "John Smith", 0, 12);
        float valueAfterTax = taxService.calculateYearIncome(validUserFromUS);
        Assertions.assertEquals(valueAfterTax, 0);
    }

    @DisplayName("Verifying net salary US citizen with 0 month of work")
    @Test
    public void basicTest3() {
        User validUserFromUS = new User(Region.US, "John Smith", 123000, 0);
        float valueAfterTax = taxService.calculateYearIncome(validUserFromUS);
        Assertions.assertEquals(valueAfterTax, 0);
    }


    @DisplayName("Verifying net salary for NO_NAME US citizen with 11 month of work")
    @Test
    public void notEnoughDataTest() {
        User invalidUserFromUS = new User(Region.US, "", 123000, 11);
        float valueAfterTax = taxService.calculateYearIncome(invalidUserFromUS);
        Assertions.assertEquals(valueAfterTax, 92455.0f);

        User invalidUserFromUS2 = new User(Region.US, null, 123000, 11);
        float valueAfterTax2 = taxService.calculateYearIncome(invalidUserFromUS2);
        Assertions.assertEquals(valueAfterTax, 92455.0f);
    }

    @DisplayName("Verifying USER methods() for NO_NAME US citizen with 11 month of work")
    @Test
    public void notEnoughDataTest2() {
        User invalidUserFromUS = new User(Region.US, "", 123000, 11);
        float valueAfterTax = taxService.calculateYearIncome(invalidUserFromUS);
        Assertions.assertEquals(valueAfterTax, 92455.0f);
        Assertions.assertEquals(invalidUserFromUS.getFullName(), "");

        User invalidUserFromUS2 = new User(Region.US, null, 123000, 11);

        assertThrows(
                UserValidationException.class,() -> taxService.calculateYearIncome(invalidUserFromUS2),
                "Expected taxService.calculateYearIncome() to throw when full name is null, but it didn't"
        );
    }

    @DisplayName("Verifying net salary for NO_region US citizen with 12 month of work")
    @Test
    public void notEnoughDataTest3() {
        User invalidUserFromUS = new User(null, "John Smith", 123000, 12);
        assertThrows(
                UserValidationException.class,() -> taxService.calculateYearIncome(invalidUserFromUS),
                "Expected taxService.calculateYearIncome() to throw when region is null, but it didn't"
        );
    }



    @DisplayName("Verifying net salary for NULL User")
    @Test
    public void nullUserTest() {
        User invalidUserFromUS = null;
        assertThrows(
                UserValidationException.class,() -> taxService.calculateYearIncome(invalidUserFromUS),
                "Expected taxService.calculateYearIncome() to throw when USER is null, but it didn't"
        );
    }


    @DisplayName("Verifying net salary for NEGATIVE MONTH_OF_WORK US citizen")
    @Test
    public void notValidDataTest1() {
        User invalidUserFromUS = new User(Region.US, "John Smith", 123000.00f, -5);
        assertThrows(
                UserValidationException.class,() -> taxService.calculateYearIncome(invalidUserFromUS),
                "Expected taxService.calculateYearIncome() to throw when NEGATIVE MONTH_OF_WORK, but it didn't"
        );
    }


    @DisplayName("Verifying net salary for NEGATIVE INCOME US citizen with 12 month of work")
    @Test
    public void notValidDataTest3() {
        User invalidUserFromUS = new User(Region.US, "John Smith", -123000.00f, 12);
        assertThrows(
                UserValidationException.class,() -> taxService.calculateYearIncome(invalidUserFromUS),
                "Expected taxService.calculateYearIncome() to throw when NEGATIVE INCOME, but it didn't"
        );
    }

}
