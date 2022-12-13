package org.example;

import org.junit.jupiter.api.Test;

import static org.example.StringValidationUtils.hasOnlyDigitsBracketsAndPlus;
import static org.example.StringValidationUtils.recipientHasGmail;
import static org.junit.jupiter.api.Assertions.*;

public class HomeWork4Tests extends DefaultTest {

    @Test
    public void testNumberWithBracketsAndPlus(){
        System.out.println(" test testNumberWithBracketsAndPlus is running! ");
        String[] positiveTestFields = new String[] {
                "89999999999",   //без скобок и без плюса
                "+79999999999",  //с плюсом
                "8(999)9999999", //со скобками
                "+7(999)9999999" //со скобками и с плюсом
        };
        String[] negativeTestFields = new String[] {
                "8(9999999999",   //с одной открывающейся скобкой
                "8999)9999999",   //с одной закрывающейся скобкой
                "8(999)999)9999", //с тремя скобками и более
                "++++++++++++++", //только плюсы
                "()()()()(()()(", //только скобки
                ""                //пустое поле
        };
        for (String positiveTestField : positiveTestFields)
            assertTrue(hasOnlyDigitsBracketsAndPlus(positiveTestField));
        for (String negativeTestField : negativeTestFields)
            assertFalse(hasOnlyDigitsBracketsAndPlus(negativeTestField));
        System.out.println(" test is passed! ");
    }

    @Test
    public void testRecipientMailboxIsGmailOnly(){
        System.out.println(" test testRecipientMailboxIsGmailOnly is running! ");
        String positiveTestField = "test@gmail.com";
        String[] negativeTestFields = new String[] {
                "test@ya.ru",
                "test@yandex.ru",
                "test@yahoo.com",
                "test@gmx.com",
                "test@dropmail.me",
        };
        assertTrue(recipientHasGmail(positiveTestField));
        for (String negativeTestField : negativeTestFields)
            assertFalse(recipientHasGmail(negativeTestField));
        System.out.println(" test is passed! ");
    }
}
