package org.example.httpserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CityApi {
    private static final CityApi instance;
    
    static {
        try {
            instance = new CityApi();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    private List<City> cities;
    private List<City> onlyFirst100cities;
    
    private CityApi() throws IOException {
        onlyFirst100cities = random100Cities(initCitiesFromUrl(), 100);
    }
    
    private List<City> initCitiesFromUrl() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://gist.githubusercontent.com/isicju/57f52dc77344eba300d6c6b051b29187/raw/1a2ff4fc5faa1ba58f7c3fcbb0d47dbd15baa340/cities";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        
        List<City> rawCities = new ArrayList<>();
        for (String cityRecord : response.getBody().split("\n")) {
            String name = cityRecord.split("\t")[1];
            String latitude = cityRecord.split("\t")[2];
            String longitude = cityRecord.split("\t")[3];
            rawCities.add(new City(name, latitude, longitude));
        }
        return rawCities;
    }
    
    private static List<City> random100Cities(List<City> city, int maxSize) {
        List<City> subCities = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            subCities.add(city.get(new Random().nextInt(city.size())));
        }
        return subCities;
    }
    
    public List<City> getOnlyFirst100cities() {
        return onlyFirst100cities;
    }
    
    public static CityApi getInstance() {
        return instance;
    }
    
}