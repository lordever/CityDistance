package com.Spring.City.dao;

import com.Spring.City.model.CityDistance;
import org.hibernate.Query;
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
    public void addCity(CityDistance cityDistance) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(cityDistance);
        logger.info("City successfully saved. City details " + cityDistance);
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

    @Override
    public CityDistance getCityById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        CityDistance cityDistance = (CityDistance) session.get(CityDistance.class, new Long(id));
        logger.info("City successfully loaded. City: " + cityDistance);

        return cityDistance;
    }

    @Override
    public void updateCity(CityDistance cityDistance) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(cityDistance);
        logger.info("City successfully update. City details: " + cityDistance);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isExistCity(String fistCity, String secondCity) {
        Session session = this.sessionFactory.getCurrentSession();
        List<CityDistance> cities = session.createQuery("from CityDistance").list();
        return cities.size() != 0;
    }

    @Override
    public void removeCity(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        CityDistance cityDistance = (CityDistance) session.load(CityDistance.class, new Long(id));

        if (cityDistance != null)
            session.delete(cityDistance);

        logger.info("City successfully removed. City details: " + cityDistance);
    }

}
