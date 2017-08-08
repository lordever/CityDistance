package com.Spring.City.model;

import com.Spring.City.jsonview.Views;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "citydistance")
public class CityDistance {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Public.class)
    private long id;

    @Column(name = "CITY_A")
    @JsonView(Views.Public.class)
    private String cityA;

    @Column(name = "CITY_B")
    @JsonView(Views.Public.class)
    private String cityB;

    @Column(name = "DISTANCE")
    @JsonView(Views.Public.class)
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
        return "CityDistance{" +
                "id=" + id +
                ", cityA='" + cityA + '\'' +
                ", cityB='" + cityB + '\'' +
                ", distance=" + distance +
                '}';
    }
}
