package org.example.taxcalc;

import org.example.DefaultTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}
