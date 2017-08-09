package com.Spring.City.model;

public class CalcCriteria {
    private String cityA;
    private String cityB;

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

    @Override
    public String toString() {
        return "CalcCriteria{" +
                "cityA='" + cityA + '\'' +
                ", cityB='" + cityB + '\'' +
                '}';
    }
}
