package org.example.taxcalc;

class User {
    final Region region;
    final String fullName;
    final Float yearIncome;
    final Integer monthOfWork;

    public User(Region region, String fullName, float yearIncome, int monthOfWork) {
        this.region = region;
        this.fullName = fullName;
        this.yearIncome = yearIncome;
        this.monthOfWork = monthOfWork;
    }

    public Region getRegion() {
        return region;
    }

    public String getFullName() {
        return fullName;
    }

    public Float getYearIncome() {
        return yearIncome;
    }

    public Integer getMonthOfWork() {
        return monthOfWork;
    }
}