package org.example.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Throws an error
public class Errors {

    public static void throwsOOOException() {
        // Example case: we are making a logs incorrectly.Instead of making writes
        // each time, we collect them till certain amount and write them.
        // Unfortunately, made the condition when collected logs are written unreachable.

        Map<Integer, Object> logsInfo = new HashMap<>();
        Map<Integer, Object> logsInfoCopy = new HashMap<>();
        int i = 0;
        while(true){
            i++;
            Object o = new Object(); // a log
            logsInfo.put(i, o);
            logsInfoCopy.put(i, o);
        }

        // *Save logs somewhere*
    }

    public static void throwsStackOverFlowError() {
        // Example case: making fibonacci for the first time
        fibonacci(100000000000000L);
    }
    private static int fibonacci(Long n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void shutDown(String password) {
        // Example case: we are using String-pull(insecure) to collect important data,
        // and we've found someone stealing the data, so admin shutdown a server;

        if (password.equals("HelloWorld")) {
            // Saving runTime info
            String date = new Date().toString();
            // Logging an error and a cause
            throw new Error();
        }
    }
}

