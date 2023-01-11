package org.example.lesson7.api;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CityApi {

    private static final CityApi instance = new CityApi();
    private static List<City> cities;
    private static List<City> hundredCities;
    private CityApi() {
        cities = initCitiesFromUrl();
        hundredCities = initHundredCities(cities);
    }

    private List<City> initCitiesFromUrl() {
        final String resourceUrl = "https://gist.githubusercontent.com/isicju/57f52dc77344eba300d6c6b051b29187/raw/1a2ff4fc5faa1ba58f7c3fcbb0d47dbd15baa340/cities";
        return getListOfCities(resourceUrl);
    }

    private List<City> getListOfCities(String resourceUrl) {
        List<City> cities = new ArrayList<>();
        for (String metadataOfCity : getServerBodyAsString(resourceUrl).split("\n")) {
            cities.add(
                    new City(
                            metadataOfCity.split("\t")[0],
                            metadataOfCity.split("\t")[1],
                            metadataOfCity.split("\t")[2],
                            metadataOfCity.split("\t")[3],
                            metadataOfCity.split("\t")[4],
                            metadataOfCity.split("\t")[5],
                            metadataOfCity.split("\t")[6],
                            metadataOfCity.split("\t")[7],
                            metadataOfCity.split("\t")[8],
                            metadataOfCity.split("\t")[9],
                            metadataOfCity.split("\t")[10]
                    ));
        }
        return cities;
    }

    public String getServerBodyAsString(String resourceUrl) {
        return new RestTemplate().getForEntity(resourceUrl, String.class).getBody();
    }

    public List<City> initHundredCities(List<City> cities) {
        List<City> hundredRandomCities = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            hundredRandomCities.add(cities.get(ThreadLocalRandom.current().nextInt(0, cities.size())));
        }
        return hundredRandomCities;
    }

    public List<City> getHundredRandomCities() {
        return hundredCities;
    }

    public List<City> getAllCities() {
        return cities;
    }

    public static CityApi getInstance() {
        return instance;
    }


}
