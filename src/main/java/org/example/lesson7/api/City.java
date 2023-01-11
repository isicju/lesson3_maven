package org.example.lesson7.api;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class City {

    private String name;
    private String nameAscii;

    private String latitude;
    private String longitude;

    private String country;

    private String isoTwoCountryOf;
    private String isoThreeCountryOf;
    private String adminName;
    private String capital;

    private String population;
    private String id;
}
