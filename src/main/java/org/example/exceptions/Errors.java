package org.example.exceptions;

import java.util.Date;

// Throws an error
public class Errors {

    public static void shutDown(String password) {
        // Case: we are using String-pull(insecure) to collect important data,
        // and we've found someone stealing the data, so admin shutdown a server;

        if (password.equals("HelloWorld")) {
            // Saving runTime info
            String date = new Date().toString();
            // Logging an error and a cause
            throw new Error();
        }
    }
}

