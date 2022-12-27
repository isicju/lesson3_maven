package org.example.homework6;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HttpServiceIntegration {
    public static List<Person> createPersonsList() {
        RestTemplate restTemplate = new RestTemplate();
        String serverURL = "http://185.106.92.99:8080/users";
        ResponseEntity<String> response = restTemplate.getForEntity(serverURL, String.class);
        if (response.getBody() == null) {
            throw new NullPointerException("Response from the server is null");
        }
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Person>>() {
        }.getType();
        return gson.fromJson(response.getBody(), listType);
    }

    public static List<Person> createPersonsListCSV() {
        RestTemplate restTemplate = new RestTemplate();
        String serverURL = "http://185.106.92.99:8080/users?format=csv";
        ResponseEntity<String> response = restTemplate.getForEntity(serverURL, String.class);
        if (response.getBody() == null) {
            throw new NullPointerException("Response from the server is null");
        }
        List<Person> persons = new ArrayList<>();
        String[] splittedResponseBody = response.getBody().split(";");
        for (String s : splittedResponseBody) {
            String[] personData = s.split(",");
            persons.add(new Person(personData[2], Integer.parseInt(personData[0]), Integer.parseInt(personData[1])));
        }
        return persons;
    }

    public static class Person {
        private String name;
        private int id;
        private int age;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id && age == person.age && Objects.equals(name, person.name);
        }

        public Person(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }
}
