package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SendingDateCalc {
    public long diffInSeconds;
    public boolean stop = false;
    public int deltaTimeSending = 30;
    
    void remainingTimeCalculation(String dateTime, String message) throws ParseException, InterruptedException {
        do {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date sendingDate = formatter.parse(dateTime);
            
            Date dateNow = new Date();
            int result = sendingDate.compareTo(dateNow);
            diffInSeconds = TimeUnit.MILLISECONDS.toSeconds(sendingDate.getTime() - dateNow.getTime());
            
            App app = new App();
            if (result == 0) {
                stop = true;
                app.flagIsDone = true;
                System.out.println("Current date and time entered");
            } else if (result < 0) {
                stop = true;
                app.flagIsDone = true;
                System.out.println("This date is from the past :-)");
            }
            //  Checking the time and sending
            if (app.flagIsDone) {
                stop = true;
            } else {
                if (diffInSeconds < deltaTimeSending && !stop) {
                    app.flagIsDone = true;
                    System.out.println(message);
                }
            }
            Thread.sleep(30000); // Sleeping 30 sec
        } while (diffInSeconds > deltaTimeSending && !stop);
    }
}