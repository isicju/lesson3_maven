package org.example.lesson7.api;

import org.apache.commons.validator.routines.UrlValidator;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

public class CityApi {
    private static final CityApi cityApiInstance = new CityApi();

    private final List<City> cities;

    private CityApi() {
        cities = initCitiesFromURL();
    }

    public static String URLReader(URL url, Charset encoding) throws IOException {
        try (InputStream in = url.openStream()) {
            byte[] bytes = in.readAllBytes();
            return new String(bytes, encoding);
        }
    }

    private List<City> initCitiesFromURL() {
        List<Integer> hundredOfRandomCityIndexes = new ArrayList<>();
        List<City> parsedHundredOfCities = new ArrayList<>();
        String parsedFromUrl;
        String[] splitURL;
            try {
                String stringUrl = "https://gist.githubusercontent.com/isicju/57f52dc77344eba300d6c6b051b29187/raw/1a2ff4fc5faa1ba58f7c3fcbb0d47dbd15baa340/cities";
                URL urlUrl = new URL(stringUrl);
                UrlValidator urlValidator = new UrlValidator();
                boolean isValidURL = urlValidator.isValid(stringUrl);
                if (isValidURL) {
                    parsedFromUrl = URLReader(urlUrl, Charset.defaultCharset());
                    splitURL = parsedFromUrl.split("\\n");
                    while (hundredOfRandomCityIndexes.size() < 100) {
                        int indexToCheck = (int)(Math.random()*splitURL.length);
                        if (!hundredOfRandomCityIndexes.contains(indexToCheck)) {
                            hundredOfRandomCityIndexes.add(indexToCheck);
                        }
                    }
                    for (int nextRandomIndex : hundredOfRandomCityIndexes) {
                        String[] s = splitURL[nextRandomIndex].split("\\t");
                        City cityToAdd = new City(s[0], s[1], Float.parseFloat(s[2]), Float.parseFloat(s[3]), s[4], s[5], s[6], s[7], s[8], s[9], Integer.parseInt(s[10]));
                        parsedHundredOfCities.add(cityToAdd);
                    }
                }
            }
            catch (MalformedURLException e) {
                System.out.println("Invalid url to follow");
            }
            catch (IOException ex) {
                System.out.println("Invalid data via url");
            }
        return parsedHundredOfCities;
    }



    public void printCities(){
        for (int i = 0; i < getAllCities().size(); i++) {
            System.out.print("City: " + getAllCities().get(i).name + "\t");
            System.out.print("City Name: " + getAllCities().get(i).name + "\t");
            System.out.print("City: " + getAllCities().get(i).city + "\t");
            System.out.print("Latitude: " + getAllCities().get(i).latitude + "\t");
            System.out.print("Longitude: " + getAllCities().get(i).longitude + "\t");
            System.out.print("Country: " + getAllCities().get(i).country + "\t");
            System.out.print("Parameter 1: " + getAllCities().get(i).paramOne + "\t");
            System.out.print("Parameter 2: " + getAllCities().get(i).paramTwo + "\t");
            System.out.print("Parameter 3: " + getAllCities().get(i).paramThree + "\t");
            System.out.print("Minor: " + getAllCities().get(i).minor + "\t");
            System.out.print("Parameter 4: " + getAllCities().get(i).paramFour + "\t");
            System.out.println("Parameter 5: " + getAllCities().get(i).paramFive + "\t");
        }
    }

    public List<City> getAllCities(){
        return cities;
    }

    public static CityApi getInstance(){
        return cityApiInstance;
    }
}
