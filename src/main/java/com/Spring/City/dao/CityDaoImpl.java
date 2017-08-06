package com.Spring.City.dao;

import com.Spring.City.model.CityDistance;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityDaoImpl implements CityDao {
    private static Logger logger = LoggerFactory.getLogger(CityDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CityDistance> getCities() {
        Session session = this.sessionFactory.getCurrentSession();
        List<CityDistance> cities = session.createQuery("from CityDistance").list();

        for (CityDistance city : cities) {
            logger.info("City: " + city);
        }

        return cities;
    }

}
