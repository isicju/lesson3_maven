package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidationUtils {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_DIGITS =
            Pattern.compile("^[0-9]*$", Pattern.CASE_INSENSITIVE);
            //Pattern.compile("^(\\+)?\\d[\\(]?\\d{3}[\\)]?\\d{3}[\\-]?\\d{2}[\\-]?\\d{2}", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_A_Z =
            Pattern.compile("^[a-zA-Z]*$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(".+@gmail\\.com$");
        Matcher domenMatcher = pattern.matcher(email);
        if(!domenMatcher.find())
        {
            return false;
        }
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public static boolean hasLengthMoreThan(String emailStr, int length) {
        return emailStr != null && emailStr.length() > length;
    }

    public static boolean hasOnlyDigits(String digit) {
        Pattern pattern = Pattern.compile("\\p{Punct}+");
        String[] words = pattern.split(digit);
        Matcher matcher = VALID_DIGITS.matcher(words.toString());
        return matcher.find();
    }

    public static boolean hasOnlyChars(String someString) {
        Matcher matcher = VALID_A_Z.matcher(someString);
        return matcher.find();
    }

}
