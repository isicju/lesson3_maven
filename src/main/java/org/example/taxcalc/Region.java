package org.example.taxcalc;

public enum Region {
    US(0.82f), EU(0.6f), SNG(0.83f), CHINA(0.80f);
    final float taxRate;

    Region(float taxRate) {
        this.taxRate = taxRate;
    }
}