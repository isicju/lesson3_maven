package org.example.lesson7.api;


import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CityApi {

    private List<City> cities;
    private final int MAX_SIZE = 100;
    private static final CityApi INSTANCE = new CityApi();

    private CityApi() {
        cities = createServerForCities();
    }

    public List<City> createServerForCities() {
        RestTemplate restTemplate = new RestTemplate();
        String serverForCities = "https://gist.githubusercontent.com/isicju/57f52dc77344eba300d6c6b051b29187/raw/1a2ff4fc5faa1ba58f7c3fcbb0d47dbd15baa340/cities";
        ResponseEntity<String> response = restTemplate.getForEntity(serverForCities, String.class);
        if (response.getBody() == null) {
            throw new IllegalArgumentException("Response from the server is null");
        }
        List<City> arrayCities = new ArrayList<>();
        String[] stringCity = response.getBody().split("\\n");
        for (String city : stringCity) {
            String[] cityData = city.split("\\t");
            arrayCities.add(new City(cityData[0], cityData[1], Double.parseDouble(cityData[2]), Double.parseDouble(cityData[3])));
        }
        List<City> random100Cities = new ArrayList<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            random100Cities.add(arrayCities.get(new Random().nextInt(arrayCities.size())));
        }
        return random100Cities;
    }

    public static CityApi getInstance() {
        return INSTANCE;
    }

    public List<City> getAllCities() {
        return cities;
    }

}