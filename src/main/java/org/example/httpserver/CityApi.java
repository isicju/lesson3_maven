package org.example.httpserver;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CityApi {

    private static CityApi instance = null;


    public List<City> getCityList() {
        File file = new File("src/main/resources/data/cities.txt");
        List<City> cityList = new ArrayList<>(100);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < 1000; i += 10) {
                String cityData = reader.readLine();
                String[] data = cityData.strip().split("\t");
                cityList.add(new City(data[1], Float.parseFloat(data[2]), Float.parseFloat(data[3])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cityList;
    }

    public byte[] getCitiesJSONArray() throws IOException {
        final List<City> cityList = getCityList();
        final ObjectMapper mapper = new ObjectMapper();
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        mapper.writeValue(out, cityList);
        return out.toByteArray();
    }

    private CityApi() {
    }

    public static CityApi getInstance() {
        if (instance == null) {
            instance = new CityApi();
        }
        return instance;
    }

    public static void main(String[] args) {
        //valid
        new CityApi().getCityList().forEach(System.out::println);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class City {
        private String name;
        private float latitude;
        private float longitude;

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    '}';
        }
    }

}
