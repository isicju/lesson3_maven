package org.example.httpserver;

import com.google.gson.GsonBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class HttpServer {
    final static String URL_USER_JSON = "http://185.106.92.99:8080/users";
    public static String URL_USER_CSV = "http://185.106.92.99:8080/users?format=csv";
    
    public static void main(String[] args) {
        System.out.println("Original JSON format string " + receptionHttp(URL_USER_JSON));
        convertJsonToLisn(receptionHttp(URL_USER_JSON));
        
        System.out.println("Original CSV format string " + receptionHttp(URL_USER_CSV));
        convertCSVToList(receptionHttp(URL_USER_CSV));
    }
    
    static String receptionHttp(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String responseBody = response.getBody();
        return responseBody;
    }
    
    private static void convertJsonToLisn(String responseBody) {
        Users[] usersList = new GsonBuilder().create().fromJson(responseBody, Users[].class);
        PrintingList(List.of(usersList));
    }
    
    private static void convertCSVToList(String responseBody) {
        List<Users> usersList = new ArrayList<>();
        String[] userArray = responseBody.split("[;]");
        for (String str : userArray) {
            String[] repackingPointer = str.split("[,]");
            String name = repackingPointer[2];
            usersList.add(new Users(repackingPointer[2], Integer.parseInt(repackingPointer[0]), Integer.parseInt(repackingPointer[1])));
        }
        PrintingList(usersList);
    }
    
    private static void PrintingList(List<Users> usersList) {
        for (Users users : usersList) {
            System.out.println(" " + users.name + " " + users.id + " " + users.age);
        }
    }
    
    static class Users {
        final String name;
        final int id;
        final int age;

        Users(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }
}

