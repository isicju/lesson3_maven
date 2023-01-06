package org.example;

import java.io.FileNotFoundException;
import java.util.Date;

public class Main {
//ivserga
    public static void main(String[] args) {
        // void
        // primitive
        // object - including null
        // exception
//            int myVal = 10/0;
//        File file = new File("C:\\noexistentfolder");
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            fis.read();
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not found");
//        } catch (IOException e) {
//            System.out.println("Exception during reading the existent file!");
//        }

        try {
            Thread.sleep(12);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            createUser("peta");
        } catch (NonExistentCreditCheckRequestException e) {
            System.out.println(e.getMessage());
        }

    }

    public static class NonExistentCreditCheckRequestException extends RuntimeException {
        String userName;
        Date incidentTime;

        public NonExistentCreditCheckRequestException(String message, String userName) {
            super(message);
            this.userName = userName;
            this.incidentTime = new Date();
        }
    }


    public static User createUser(String userName)  {

    if(userName.isEmpty()) throw new IllegalArgumentException();

        User user = new User(userName);
        validateUser(user);
        return user;
    }

    public static void validateUser(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
//            throw new NonExistentCreditCheckRequestException("user is not valid");
        }
    }

    static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User(String name) {
            this.name = name;
        }
    }

}