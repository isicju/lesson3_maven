package org.example.taxcalc;

public class UserValidationException extends RuntimeException {
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    UserValidationException(String message, User user) {
        super(message);
        this.user = user;
    }
}