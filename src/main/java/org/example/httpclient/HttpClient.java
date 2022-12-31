package org.example.httpclient;

import com.google.gson.GsonBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpClient {

    public final String SERVER;
    public final String SERVER_CSV = "http://185.106.92.99:8080/users?format=csv";

    public RestTemplate restTemplate = new RestTemplate();

    HttpClient(String serverUrl){
        SERVER = "http://" + serverUrl;
    }

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public User(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }


}
