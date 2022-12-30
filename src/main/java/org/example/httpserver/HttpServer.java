package org.example.httpserver;

import com.google.gson.Gson;
import com.sun.source.util.SourcePositions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpServer {
    static RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
        String resourceUrl = "http://185.106.92.99:8080/users";
        String resourceUrlCsv = "http://185.106.92.99:8080/users?format=csv";
        System.out.println(createListFromJson(resourceUrl));
        System.out.println(createListCsv(resourceUrlCsv));
    }

    public static List<Users1> createListFromJson(String resourceUrl) {
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        return Arrays.asList(new Gson().fromJson(response.getBody(), Users1[].class));
    }
    public static List<Users1> createListCsv(String resourceUrl){
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        List<Users1> listUsers = new ArrayList<>();
        String[] users = response.getBody().split(";");
        for (String str : users){
            String[] usersSplit = str.split(",");
            listUsers.add(new Users1(usersSplit[2], Integer.parseInt(usersSplit[0]), Integer.parseInt(usersSplit[1])));
        }
        return listUsers;
    }
}
