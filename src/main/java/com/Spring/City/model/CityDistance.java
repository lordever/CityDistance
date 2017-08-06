package com.Spring.City.model;

import javax.persistence.*;

@Entity
@Table(name = "citydistance")
public class CityDistance {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CITY_A")
    private String cityA;

    @Column(name = "CITY_B")
    private String cityB;

    @Column(name = "DISTANCE")
    private int distance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return "CityDistance{" +
                "id=" + id +
                ", cityA='" + cityA + '\'' +
                ", cityB='" + cityB + '\'' +
                ", distance=" + distance +
                '}';
    }
}
