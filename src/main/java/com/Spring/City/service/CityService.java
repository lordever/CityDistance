package com.Spring.City.service;

import com.Spring.City.model.CityDistance;

import java.util.List;

public interface CityService {
    public List<CityDistance> getCities();

    public CityDistance getCityById(long id);

    public void addCity(CityDistance cityDistance);

    public void updateCity(CityDistance cityDistance);

    public void removeCity(long id);
}
