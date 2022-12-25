package org.example.httpserver;

import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * The IntegrationWithHttpServer class represent connection with URL to collect data from it
 */

public class IntegrationWithHttpServer {
    /**
     * Create list of Person that have in {@code resourceURL}.
     * @throws  RuntimeException
     *          If no connection with {@code resourceURL}.
     */
    public static List<Person> createList(String resourceURL) {
        checkConnection(resourceURL);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(resourceURL, String.class);
        return Arrays.asList(new Gson().fromJson(response.getBody(), Person[].class));
    }

    /**
     * Create list of Person that have in {@code resourceURL} from CSV format.
     * @throws  RuntimeException
     *          If no connection with {@code resourceURL}.
     */

    public static List<Person> createListCSV(String resourceURL) {
        checkConnection(resourceURL);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(resourceURL, String.class);
        String[] listSplit = Objects.requireNonNull(response.getBody()).split(";");
        List<Person> personList = new ArrayList<>();
        for (String s : listSplit) {
            String[] dataFromUser = s.split(",");
            personList.add(new Person(dataFromUser[2], Long.parseLong(dataFromUser[0]), Integer.parseInt(dataFromUser[1])));
        }
        return personList;
    }

    /**
     * Check that has connection with {@code resourceURL}.
     * @throws  RuntimeException
     *          If no connection with {@code resourceURL}.
     */

    private static void checkConnection(String resourceURL) {
        try {
            URL myURL = new URL(resourceURL);
            URLConnection myURLConnection = myURL.openConnection();
            myURLConnection.connect();
        } catch (IOException e) {
            throw new RuntimeException("Cannot connect with resource");
        }
    }

    static class Person {
        private final String name;
        private final Long id;
        private final int age;

        public Person(String name, Long id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && Objects.equals(name, person.name) && Objects.equals(id, person.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id, age);
        }
    }

}

