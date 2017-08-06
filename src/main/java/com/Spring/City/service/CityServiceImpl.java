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
    public List<CityDistance> getCities() {
        return this.cityDao.getCities();
    }
}
