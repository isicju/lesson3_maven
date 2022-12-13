package org.example;

import org.junit.jupiter.api.Test;

import static org.example.StringValidationUtils.hasOnlyDigitsBracketsAndPlus;
import static org.junit.jupiter.api.Assertions.*;

public class HomeWork4Tests extends DefaultTest {

    @Test
    public void testNumberWithBracketsAndPlus(){
        System.out.println(" test is running! ");
        String[] positiveTestFields = new String[] {
                "89999999999",   //без скобок и без плюса
                "+79999999999",  //с плюсом
                "8(999)9999999", //со скобками
                "+7(999)9999999" //со скобками и с плюсом
        };
        String[] negativeTestFields = new String[] {
                "+7(9999999999",   //с одной открывающейся скобкой
                "+7999)9999999",   //с одной закрывающейся скобкой
                "+7(999)999)9999", //с тремя скобками и более
        };
        for (String positiveTestField : positiveTestFields) {
            assertTrue(hasOnlyDigitsBracketsAndPlus(positiveTestField));
        }
        for (String negativeTestField : negativeTestFields) {
            assertTrue(!hasOnlyDigitsBracketsAndPlus(negativeTestField));
        }
    }
}
