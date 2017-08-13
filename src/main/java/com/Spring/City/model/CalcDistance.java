package com.Spring.City.model;

public class CalcDistance {
    private String firstCity;
    private String secondCity;
    private String distance;

    public String getFirstCity() {
        return firstCity;
    }

    public void setFirstCity(String firstCity) {
        this.firstCity = firstCity;
    }

    public String getSecondCity() {
        return secondCity;
    }

    public void setSecondCity(String secondCity) {
        this.secondCity = secondCity;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "CalcDistance{" +
                "firstCity='" + firstCity + '\'' +
                ", secondCity='" + secondCity + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
