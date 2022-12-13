package org.example.model;

import static org.example.StringValidationUtils.hasLengthMoreThan;
import static org.example.StringValidationUtils.isValidEmail;
import static org.example.StringValidationUtils.isValidGmail;

public class EmailMessage {
    private final String email;
    private final String textMessage;

    public String getEmail() {
        return email;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public EmailMessage(String email, String textMessage) {
        if (!isValidEmail(email)) {
            throw new RuntimeException("email: " + email + " is invalid!");
        }
        if (!isValidGmail(email)) {
            throw new RuntimeException("email domain: " + email + " is not allowed!");
        }
        if (!hasLengthMoreThan(textMessage, 3)) {
            throw new RuntimeException("message text: " + textMessage + " is invalid!");
        }
        this.email = email;
        this.textMessage = textMessage;
    }
}
