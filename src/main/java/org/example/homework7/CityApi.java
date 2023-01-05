package org.example.homework7;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CityApi {
    private static final CityApi instance = new CityApi();

    private List<City> cities;

    private CityApi() {
        cities = initCitiesFromURL();
    }

    private List<City> initCitiesFromURL() {
        RestTemplate restTemplate = new RestTemplate();
        String citiesDataURL = "https://gist.githubusercontent.com/isicju/57f52dc77344eba300d6c6b051b29187/raw/1a2ff4fc5faa1ba58f7c3fcbb0d47dbd15baa340/cities";
        ResponseEntity<String> response = restTemplate.getForEntity(citiesDataURL, String.class);
        if (response.getBody() == null) {
            throw new IllegalStateException("Response from the server is null");
        }

        List<City> cities = new ArrayList<>();
        String[] splittedResponseBody = response.getBody().split("\\n");
        for (String s : splittedResponseBody) {
            String[] cityData = s.split("\\t");
            cities.add(new City(cityData[1], Double.parseDouble(cityData[2]), Double.parseDouble(cityData[3])));
        }

        Random random = new Random();
        int numberOfRemovedCities = cities.size() - 100;
        for (int i = 0; i < numberOfRemovedCities; i++) {
            int randomIndex = random.nextInt(cities.size());
            City randomCity = cities.get(randomIndex);
            cities.remove(randomIndex);
        }

        return cities;
    }

    public List<City> getCities() {
        return cities;
    }

    public static CityApi getInstance() {
        return instance;
    }

}
