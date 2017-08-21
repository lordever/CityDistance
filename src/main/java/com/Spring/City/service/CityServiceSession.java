package com.Spring.City.service;

import com.Spring.City.model.City;

import java.util.List;

public interface CityServiceSession {
    List<City> getAll();

    City get(long id);

    void remove(long id);

    void add(City city);

    void update(City city);
}
