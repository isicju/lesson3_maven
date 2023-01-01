package org.example.httpserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CityApi {
    private static final CityApi instance = new CityApi();

    private List<City> cities;
    private List<City> onlyFirst100cities;

    private CityApi() {
        cities = initCitiesFroUrl();
        onlyFirst100cities = random100Cities(cities, 1000);
    }

    private List<City> initCitiesFroUrl() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://gist.githubusercontent.com/isicju/57f52dc77344eba300d6c6b051b29187/raw/1a2ff4fc5faa1ba58f7c3fcbb0d47dbd15baa340/cities";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        List<City> newCities = new ArrayList<>();
        for (String cityRecord : response.getBody().split("\n")) {
            String cityName = cityRecord.split("\t")[0];
            String latitude = cityRecord.split("\t")[2];
            String longitude = cityRecord.split("\t")[3];
            String countryName = cityRecord.split("\t")[4];
            newCities.add(new City(countryName, cityName, latitude, longitude));
        }
        return newCities;
    }

    private static List<City> random100Cities(List<City> cities, int maxSize) {
        List<City> subCities = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            subCities.add(cities.get(new Random().nextInt(cities.size())));
        }
        return subCities;
    }

    public List<City> getOnlyFirst100cities() {
        return onlyFirst100cities;
    }

    public List<City> getAllCities() {
        return cities;
    }

    public static CityApi getInstance() {
        return instance;
    }

    public static class City {
        String country;
        String name;
        String latitude;
        String longitude;

        public City(String country, String name, String latitude, String longitude) {
            this.country = country;
            this.name = name;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }
    }

}
