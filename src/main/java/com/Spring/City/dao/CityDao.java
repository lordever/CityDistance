package com.Spring.City.dao;

import com.Spring.City.model.CityDistance;

import java.util.List;

public interface CityDao {
    public List<CityDistance> getCities();

    public CityDistance getCityById(long id);

    public void addCity(CityDistance cityDistance);

    public void updateCity(CityDistance cityDistance);

    public boolean isExistCity(String fistCity, String secondCity);

    public void removeCity(long id);
}
