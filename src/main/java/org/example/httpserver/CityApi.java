package org.example.httpserver;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CityApi {


    private static CityApi instance = null;
    private static int numberOfAppeals = 0;

    public List<City> getCityList() {
        File file = new File("src/main/resources/data/cities.txt");
        List<City> cityList = new ArrayList<>(100);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            // skipping numberOfAppeals*100 lines(cities)
            for (int j = 0; j < numberOfAppeals * 100; j++) {
                reader.readLine();
            }
            // reading 100 lines(cities)
            for (int i = 0; i < 100; i++) {
                String cityData = reader.readLine();
                String[] data = cityData.strip().split("\t");
                cityList.add(new City(data[1], Float.parseFloat(data[2]), Float.parseFloat(data[3])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        numberOfAppeals += 1;
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
        if (Objects.isNull(instance)) {
            instance = new CityApi();
        }
        return instance;
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
