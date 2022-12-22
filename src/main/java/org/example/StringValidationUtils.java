package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidationUtils {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_DIGITS =
            Pattern.compile("^[0-9]*$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_A_Z =
            Pattern.compile("^[a-zA-Z]*$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_CIS_NUMBER =
            Pattern.compile("^\\+?(994|374|375|7|996|373|992|993|998|380)\\(?[0-9]{2,4}\\)?[0-9]{3}-?[0-9]{2}-?[0-9]{2}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_GMAIL_ADDRESS_REGEX =
            Pattern.compile("^[a-z0-9]+(?!.*(?:\\+{2,}|-{2,}|\\.{2,}))(?:[.+\\-]?[a-z0-9])*@gmail\\.com$", Pattern.CASE_INSENSITIVE);

    public static boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public static boolean hasLengthMoreThan(String emailStr, int length) {
        return emailStr != null && emailStr.length() > length;
    }

    public static boolean hasOnlyDigits(String digit) {
        Matcher matcher = VALID_DIGITS.matcher(digit);
        return matcher.find();
    }

    public static boolean hasOnlyChars(String someString) {
        Matcher matcher = VALID_A_Z.matcher(someString);
        return matcher.find();
    }

    public static boolean isValidNumber(String number) {
        Matcher matcher = VALID_CIS_NUMBER.matcher(number);
        return matcher.find();
    }

    public static boolean isValidGmail(String email) {
        Matcher matcher = VALID_GMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

}
