package org.example.online;

import org.example.lesson7.api.City;

import java.util.ArrayList;
import java.util.List;

public class CityApiService {

    private List<City> cities = new ArrayList<>();

    private static final CityApiService instance = new CityApiService();


    public CityApiService() {

    }

    public static CityApiService getInstance() {
        return instance;
    }

    public List<City> getCities() {
        return cities;
    }
}
