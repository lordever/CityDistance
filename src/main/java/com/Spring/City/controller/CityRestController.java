package com.Spring.City.controller;

import com.Spring.City.jsonview.Views;
import com.Spring.City.model.AjaxResponseBody;
import com.Spring.City.model.CityDistance;
import com.Spring.City.model.SearchCriteria;
import com.Spring.City.service.CityService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityRestController {

    private List<CityDistance> cities;
    private CityDistance city;
    private CityService cityService;

    @Autowired
    @Qualifier(value = "cityService")
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "cities/rest/test")
    public AjaxResponseBody getResult(@RequestBody SearchCriteria criteria) {
        AjaxResponseBody result = new AjaxResponseBody();

        if (isValidSearchCriteria(criteria)) {
            cities = cityService.getCities();

            if (cities.size() > 0) {
                result.setCode("200");
                result.setMessage("");
                result.setResult(cities);
            } else {
                result.setCode("204");
                result.setMessage("No city");
            }
        } else {
            result.setCode("400");
            result.setMessage("Search criteria is empty!");
        }

        return result;
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "cities/rest/add")
    public AjaxResponseBody addBook(@RequestBody SearchCriteria criteria) {
        AjaxResponseBody result = new AjaxResponseBody();

        if (isValidSearchCriteria(criteria)) {
            cityService.addCity(buildCityDistance(criteria));

            result.setCode("200");
            result.setMessage("");
            result.setResultCriteria(criteria);
        } else {
            result.setCode("400");
            result.setMessage("Search criteria is empty!");
        }

        return result;
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "cities/rest/edit")
    public AjaxResponseBody updateBook(@RequestBody SearchCriteria criteria) {
        AjaxResponseBody result = new AjaxResponseBody();

        if(isValidSearchCriteria(criteria)){
            cityService.updateCity(buildCityDistance(criteria));

            result.setCode("200");
            result.setMessage("");
            result.setResultCriteria(criteria);
        }else{
            result.setCode("400");
            result.setMessage("Search criteria is empty!");
        }

        return result;
    }


    private boolean isValidSearchCriteria(SearchCriteria criteria) {
        boolean valid = true;

        if (criteria == null) {
            valid = false;
        } else if (criteria.getCityA().equals("")) {
            valid = false;
        } else if (criteria.getCityB().equals("")) {
            valid = false;
        }

        return valid;
    }

    private CityDistance buildCityDistance(SearchCriteria criteria) {
        CityDistance cityDistance = new CityDistance();

        cityDistance.setCityA(criteria.getCityA());
        cityDistance.setCityB(criteria.getCityB());
        cityDistance.setDistance(criteria.getDistance());

        return cityDistance;
    }

}
