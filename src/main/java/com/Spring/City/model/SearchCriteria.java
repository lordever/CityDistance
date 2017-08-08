package com.Spring.City.model;

public class SearchCriteria {
    private long id;
    private String cityA;
    private String cityB;
    private int distance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityA() {
        return cityA;
    }

    public void setCityA(String cityA) {
        this.cityA = cityA;
    }

    public String getCityB() {
        return cityB;
    }

    public void setCityB(String cityB) {
        this.cityB = cityB;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "id=" + id +
                ", cityA='" + cityA + '\'' +
                ", cityB='" + cityB + '\'' +
                ", distance=" + distance +
                '}';
    }
}
