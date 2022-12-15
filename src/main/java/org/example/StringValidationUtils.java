package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidationUtils {
//    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
//            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[a-zA-Z0-9_.+-]+?@gmail.com$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_DIGITS =
            Pattern.compile("^[0-9]*$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_A_Z =
            Pattern.compile("^[a-zA-Z]*$", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_PHONE_REGION_AND_NUMBER_REGEX =
            Pattern.compile("^\\+*(?:7|373|374|375|380|993|994|996|998)[-(]*\\d{3}[-)]*\\d{3}-*\\d{2}-*\\d{2}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern VALID_PHONE_REGION =
            Pattern.compile("^\\+*(?:7|373|374|375|380|993|994|996|998)", Pattern.CASE_INSENSITIVE);

    public static boolean isValidPhone(String phone) {
        Matcher matcher = VALID_PHONE_REGION_AND_NUMBER_REGEX.matcher(phone);
        return matcher.find();
    }

    public static boolean isValidPhoneRegion(String phone) {
        Matcher matcher = VALID_PHONE_REGION.matcher(phone);
        return matcher.find();
    }

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

}
