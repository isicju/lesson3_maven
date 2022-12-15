package org.example.utils;

import org.example.DefaultTest;
import org.junit.jupiter.api.Test;

import static org.example.utils.StringValidationUtils.hasOnlyDigitsBracketsAndPlus;
import static org.example.utils.StringValidationUtils.recipientHasGmail;
import static org.junit.jupiter.api.Assertions.*;

public class StringValidationUtilsTest extends DefaultTest {

    @Test
    public void testNumberWithBracketsAndPlus(){
        System.out.println(" test testNumberWithBracketsAndPlus is running! ");
        String[] positiveTestFields = new String[] {
                "89999999999",   //no brackets && no pluses
                "+79999999999",  //with plus
                "8(999)9999999", //with 2 brackets
                "+7(999)9999999" //with plus && 2 brackets
        };
        String[] negativeTestFields = new String[] {
                "8(9999999999",   //one opening bracket
                "8999)9999999",   //one closing bracket
                "8(999)999)9999", //3+ brackets
                "++++++++++++++", //only pluses
                "()()()()(()()(", //only brackets
                ""                //empty field
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
