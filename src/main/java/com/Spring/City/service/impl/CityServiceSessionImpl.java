package com.Spring.City.service.impl;

import com.Spring.City.model.City;
import com.Spring.City.service.CityServiceSession;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CityServiceSessionImpl implements CityServiceSession {
    private List<City> cities = new ArrayList<City>();

    public CityServiceSessionImpl() {
        for(int i=0; i < 5; i++) {
            City city = new City(i, "City_"+i, "City_"+i, i*2);
            cities.add(city);
        }
    }

    public List<City> getAll() {
        return cities;
    }

    public City get(long id) {
        for (City city : cities) {
            if (city.getId() == id) {
                return city;
            }
        }
        return new City();
    }

    public void remove(long id) {
        for(int i=0; i < cities.size(); i++) {
            if(cities.get(i).getId() == id)
                cities.remove(i);
        }
    }

    public void add(City city) {
        boolean isHasElement = false;
        for (City cityObj : cities) {
            if (cityObj.getId() == city.getId()) {
                isHasElement = true;
            }
        }
        if(!isHasElement)
            cities.add(city);
    }

    public void update(City city) {
        for(int i=0; i < cities.size(); i++) {
            if(cities.get(i).getId() == city.getId())
                cities.set(i, city);
        }
    }
}
