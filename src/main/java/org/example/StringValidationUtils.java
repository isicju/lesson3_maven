package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class StringValidationUtils {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            compile("^[A-Z0-9._%+-]{1,50}]@[A-Z0-9.-]{1,50}\\.[A-Z]{2,6}$", CASE_INSENSITIVE);

    private static final Pattern GMAIL_MAILBOX =
            compile("^[A-Z0-9.]{1,30}@[g][m][a][i][l]\\.[c][o][m]$", CASE_INSENSITIVE);

    private static final Pattern VALID_NUMBER =
            compile("^([+]{0,1}[0-9]{1,20}[(]{1}[0-9]{1,20}[)]{1}[0-9]{1,20})|([+]{0,1}[0-9]{1,20})$", CASE_INSENSITIVE);

    private static final Pattern VALID_A_Z =
            compile("^[a-zA-Z]*$", CASE_INSENSITIVE);

    private static final Pattern Azerbaijan =
            compile("^[+][9]{1}[9]{1}[4]{1}([0-9]{9}|([(]{1}[0-9]{2}[)]{1}[0-9]{7}))$", CASE_INSENSITIVE);
    private static final Pattern Armenia =
            compile("^[+][3]{1}[7]{1}[4]{1}([0-9]{8}|([(]{1}[0-9]{2}[)]{1}[0-9]{6}))$", CASE_INSENSITIVE);
    private static final Pattern Belarus =
            compile("^[+][3]{1}[7]{1}[5]{1}([0-9]{9}|([(]{1}[0-9]{2}[)]{1}[0-9]{7}))$", CASE_INSENSITIVE);
    private static final Pattern Kazakhstan =
            compile("^[+][7]{1}([0-9]{10}|([(]{1}[7]{1}[0-9]{2}[)]{1}[0-9]{7}))$", CASE_INSENSITIVE);
    private static final Pattern Kyrgyzstan =
            compile("^[+][9]{1}[9]{1}[6]{1}([0-9]{9}|([(]{1}[0-9]{3}[)]{1}[0-9]{6})|([(]{1}[0-9]{2}[)]{1}[0-9]{7}))$", CASE_INSENSITIVE);
    private static final Pattern Moldova =
            compile("^[+][3]{1}[7]{1}[3]{1}([0-9]{8}|([(]{1}[0-9]{2}[)]{1}[0-9]{6})|([(]{1}[0-9]{3}[)]{1}[0-9]{5}))$", CASE_INSENSITIVE);
    private static final Pattern Russia =
            compile("^[+][7]{1}([0-9]{10}|([(]{1}[9]{1}[0-9]{2}[)]{1}[0-9]{7}))$", CASE_INSENSITIVE);
    private static final Pattern Tajikistan =
            compile("^[+][9]{1}[9]{1}[2]{1}([0-9]{9}|([(]{1}[0-9]{2}[)]{1}[0-9]{7})|([(]{1}[0-9]{3}[)]{1}[0-9]{6}))$", CASE_INSENSITIVE);
    private static final Pattern Uzbekistan =
            compile("^[+][9]{1}[9]{1}[8]{1}([0-9]{9}|([(]{1}[0-9]{2}[)]{1}[0-9]{7}))$", CASE_INSENSITIVE);

    private static final Pattern[] VALID_CIS = new Pattern[]{
            Azerbaijan,
            Armenia,
            Belarus,
            Kazakhstan,
            Kyrgyzstan,
            Moldova,
            Russia,
            Tajikistan,
            Uzbekistan,
    };

    public static boolean isValidEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public static boolean hasLengthMoreThan(String emailStr, int length) {
        return emailStr != null && emailStr.length() > length;
    }

    public static boolean hasOnlyDigitsBracketsAndPlus(String digit) {
        Matcher matcher = VALID_NUMBER.matcher(digit);
        return matcher.matches();
    }

    public static boolean hasOnlyChars(String someString) {
        Matcher matcher = VALID_A_Z.matcher(someString);
        return matcher.find();
    }

    public static boolean numberIsFromCIS(String someString) {
        for (Pattern countryPattern : VALID_CIS) {
            Matcher matcher = countryPattern.matcher(someString);
            if (matcher.find()) {
                System.out.println("Номер телефона " + someString + " принадлежит стране СНГ " + countryPattern);
                return true;
            }
        }
        return false;
    }

    public static boolean recipientHasGmail(String someString) {
        Matcher matcher = GMAIL_MAILBOX.matcher(someString);
        return matcher.find();
    }
}
