package com.Spring.City.service;

import com.Spring.City.dao.CityDao;
import com.Spring.City.model.CityDistance;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    private CityDao cityDao;

    public CityDao getCityDao() {
        return cityDao;
    }

    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    @Transactional
    public void addCity(CityDistance cityDistance) {
        this.cityDao.addCity(cityDistance);
    }

    @Override
    @Transactional
    public void updateCity(CityDistance cityDistance) {
        this.cityDao.updateCity(cityDistance);
    }

    @Override
    @Transactional
    public void removeCity(long id) {
        this.cityDao.removeCity(id);
    }

    @Override
    @Transactional
    public List<CityDistance> getCities() {
        return this.cityDao.getCities();
    }

    @Override
    @Transactional
    public CityDistance getCityById(long id) {
        return this.cityDao.getCityById(id);
    }
}
