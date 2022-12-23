package org.example.validators;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PhoneValidationUtils {
    public static boolean isCisNumber(String phone){
        // KZ - +7 11X
        // RUS +7 10X
        // UKR +380 10X
        // EST +372 7X
        // AZER +994 10X
        String justNumber = parseNumber(phone);
        List<String> patterns = new ArrayList<>();

        patterns.add("7[0-9]{11}");
        patterns.add("7[0-9]{10}");
        patterns.add("380[0-9]{10}");
        patterns.add("372[0-9]{7}");
        patterns.add("994[0-9]{10}");

        for(String regex: patterns){
            if(Pattern.matches(regex, justNumber)) {
                    return true;
                }
        }
        return false;
    }

    private static String parseNumber(String number){

        return number;
    }
}
