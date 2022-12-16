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


    // Homework_4 Part 1
    private static final Pattern CUSTOM_VALID_RUS = Pattern.compile("^7[0-9]{10}$");
    private static final Pattern CUSTOM_VALID_UKR = Pattern.compile("^380[0-9]{8}$");
    private static final Pattern CUSTOM_VALID_BEL = Pattern.compile("^375[0-9]{8}$");

    public static boolean validSNGNumber(String digit) {
        Matcher matcher1 = CUSTOM_VALID_RUS.matcher(digit);
        Matcher matcher2 = CUSTOM_VALID_UKR.matcher(digit);
        Matcher matcher3 = CUSTOM_VALID_BEL.matcher(digit);
        return matcher1.find() || matcher2.find() || matcher3.find();
    }

    // Homework_4 Part 2
    private static final Pattern VALID_NUMBER_PLUS = Pattern.compile("^\\+7\\(?(\\d{3})\\)?-?\\d\\d\\d-?\\d\\d\\d\\d$");

    public static boolean validNumberPlus(String digit) {
        Matcher matcher = VALID_NUMBER_PLUS.matcher(digit);
        return matcher.find();
    }


    // Homework_4 Part 1
    private static final Pattern VALID_RECIPIENT_MAIL = Pattern.compile("^[A-Z0-9._%+-]+@gmail+.+com$");

    public static boolean validSendMessage(String msg) {
        Matcher matcher = VALID_NUMBER_PLUS.matcher(msg);
        return matcher.find();
    }
}
