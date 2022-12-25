package org.example.httpserver;

import com.google.gson.GsonBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResponseGetter {

    public static void main(String[] args) {
        System.out.println("Case one");
        usersListPrinter(getUsersListFromURL("http://185.106.92.99:8080/users"));
        System.out.println("Case two");
        usersListPrinter(getUsersListFromURL("http://185.106.92.99:8080/users?format=csv"));
        System.out.println("Case three");
        usersListPrinter(getUsersListFromURL("http://185.106.92.99:8080"));
    }

    private static List<User> getUsersListFromURL(String url) {
        if (url.contains("users")) {
            if (url.contains("csv")) {
                System.out.println("Parsing users from CSV started...");
                return getUsersListFromCSV(url);
            } else {
                System.out.println("Parsing users from JSON started...");
                return getUsersListFromJson(url);
            }
        } else {
            return null;
        }
    }

    private static List<User> getUsersListFromJson(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String responseBody = response.getBody();
        User[] usersArray = new GsonBuilder().create().fromJson(responseBody, User[].class);
        return Arrays.asList(usersArray);
    }

    private static List<User> getUsersListFromCSV(String url) {
        List<User> UsersListFromCSV = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String responseBody = response.getBody();
        String[] usersStringArray = responseBody != null ? responseBody.split(";") : null;
        if (usersStringArray != null) {
            for (String s : usersStringArray) {
                String[] userParameterStringArray = s.split(",");
                String newUserName = userParameterStringArray[2];
                int newUserAge = Integer.parseInt(userParameterStringArray[1]);
                int newUserId = Integer.parseInt(userParameterStringArray[0]);
                UsersListFromCSV.add(new User(newUserName, newUserId, newUserAge));
            }
        }
        return UsersListFromCSV;
    }

    private static void usersListPrinter(List<User> userList) {
        if (userList != null && userList.size() > 0) {
            for (User user : userList) {
                System.out.print("name: " + user.name + ", ");
                System.out.print("id: " + user.id + ", ");
                System.out.println("age: " + user.age);
            }
            System.out.println();
        } else {
            System.out.print("There are no users on this link");
        }
    }
}
