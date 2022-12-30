package org.example;

import java.util.Date;

public class DateUtil {

    public static boolean isWithinInterval(Date date, long currentTime,  long interval) {
        long inputDataMilliseconds = date.getTime();
        return Math.abs((inputDataMilliseconds - currentTime)) < interval;
    }

}
