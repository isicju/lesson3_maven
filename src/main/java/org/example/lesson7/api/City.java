package org.example.lesson7.api;

public class City {
    String name;
    String city;
    float latitude;
    float longitude;
    String country;
    String paramOne;
    String paramTwo;
    String paramThree;

    String minor;
    String paramFour;
    int paramFive;

    public City(String name,
                String city,
                float latitude,
                float longitude,
                String country,
                String paramOne,
                String paramTwo,
                String paramThree,
                String minor,
                String paramFour,
                int paramFive) {
        this.name = name;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.paramOne = paramOne;
        this.paramTwo = paramTwo;
        this.paramThree = paramThree;
        this.minor = minor;
        this.paramFour = paramFour;
        this.paramFive = paramFive;
    }
}
