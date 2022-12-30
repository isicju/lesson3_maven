package org.example.httpserver;

import com.google.gson.GsonBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpServer {

    public final String SERVER = "http://185.106.92.99:8080/users";
    public final String SERVER_CSV = "http://185.106.92.99:8080/users?format=csv";

    public RestTemplate restTemplate = new RestTemplate();

    public List<User> createUserList() {
        ResponseEntity<String> response = restTemplate.getForEntity(SERVER, String.class);
        if (response.getBody() == null) {
            throw new NullPointerException("Response from the server is null");
        }
        return Arrays.asList(new GsonBuilder().create().fromJson(response.getBody(), User[].class));
    }

    public List<User> createUserListCSV() {
        ResponseEntity<String> response = restTemplate.getForEntity(SERVER_CSV, String.class);
        if (response.getBody() == null) {
            throw new NullPointerException("Response from the server is null");
        }
        List<User> users = new ArrayList<>();
        String[] stringUser = response.getBody().split(";");
        for (String user : stringUser) {
            String[] userData = user.split(",");
            users.add(new User(userData[2],
                    Integer.parseInt(userData[0]),
                    Integer.parseInt(userData[1])));
        }
        return users;
    }

    public class User {
        private String name;
        private int id;
        private int age;

        public User(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }


}
