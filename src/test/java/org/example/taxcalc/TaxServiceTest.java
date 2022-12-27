package org.example.taxcalc;

import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaxServiceTest extends DefaultTest {

    TaxService taxService;

    @BeforeEach
    public void init(){
        taxService = new TaxService();
    }

    @DisplayName("Verifying net salary for US citizen with 12 month of work")
    @Test
    public void simpleTest(){
        User validUserFromUS = new User(Region.US, "John Smith",  123000, 12);
        float valueAfterTax = taxService.calculateYearIncome(validUserFromUS);
        Assertions.assertEquals(valueAfterTax, 100860.0f);
    }

    @DisplayName("Verifying null user")
    @Test
    public void nullUserTest(){
        Assertions.assertThrows(UserValidationException.class,
                () -> taxService.calculateYearIncome(null),
                "Had to trow an exception but it didn't");
    }

    @DisplayName("Verifying null region")
    @Test
    public void nullRegionTest(){
        User invalidUserFromUS = new User(null, "John Smith",  123000, 12);
        Assertions.assertThrows(UserValidationException.class,
                () -> taxService.calculateYearIncome(invalidUserFromUS),
                "Had to trow an exception but it didn't");
    }

    @DisplayName("Verifying user FullName getter")
    @Test
    public void userFullNameGetterTest(){
        User validUserFromUS = new User(Region.US, "John Smith",  123000, 12);
        assertEquals("John Smith", validUserFromUS.getFullName());
    }

    @DisplayName("Verifying user getter")
    @Test
    public void userGetterTest(){
        User validUserFromUS = new User(Region.US, "John Smith",  123000, 12);
        UserValidationException exception = new UserValidationException("", validUserFromUS);
        assertEquals(exception.getUser(), validUserFromUS);
    }

    @DisplayName("Verifying user getter")
    @Test
    public void userSetterTest(){
        User first = new User(Region.US, "John Smith",  123000, 12);
        User second = new User(Region.US, "Mister Andersen",  481516, 1);
        UserValidationException exception = new UserValidationException("", first);
        exception.setUser(second);
        assertEquals(exception.getUser(), second);
    }
}
