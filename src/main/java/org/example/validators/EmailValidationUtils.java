package org.example.validators;

import java.util.regex.Pattern;

public class EmailValidationUtils {
    public static boolean isGmail(String adress){
        String regex = "[.|\\.]+@gmail\\.com";
        return Pattern.matches(regex, adress);
    }


}
