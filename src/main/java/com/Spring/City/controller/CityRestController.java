package com.Spring.City.controller;

import com.Spring.City.jsonview.Views;
import com.Spring.City.model.AjaxResponseBody;
import com.Spring.City.model.CityDistance;
import com.Spring.City.model.SearchCriteria;
import com.Spring.City.service.CityService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class CityRestController {

    private CityService cityService;

    @Autowired
    @Qualifier(value = "cityService")
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "rest/post")
    public AjaxResponseBody addCity(@RequestBody SearchCriteria criteria) {
        AjaxResponseBody result = new AjaxResponseBody();

        if (isValidSearchCriteria(criteria)) {
            if (criteria.getId() == 0)
                cityService.addCity(buildCityDistance(criteria));
            else
                cityService.updateCity(buildCityDistance(criteria));
            result.setCode("200");
            result.setMessage("");
            result.setResultCriteria(criteria);
        } else {
            result.setCode("400");
            result.setMessage("Criteria is empty!");
        }

        return result;
    }

    @JsonView(Views.Public.class)
    @RequestMapping(value = "rest/edit")
    public AjaxResponseBody updateCity(@RequestBody SearchCriteria criteria) {
        AjaxResponseBody result = new AjaxResponseBody();

        if (isValidSearchCriteria(criteria)) {
            cityService.updateCity(buildCityDistance(criteria));

            result.setCode("200");
            result.setMessage("");
            result.setResultCriteria(criteria);
        } else {
            result.setCode("400");
            result.setMessage("Search criteria is empty!");
        }

        return result;
    }

    @RequestMapping(value = "rest/remove/{id}", method = RequestMethod.GET)
    public void removeCity(@PathVariable(value = "id") long id, HttpServletResponse resp) throws IOException {
        this.cityService.removeCity(id);
        resp.sendRedirect("/cities");
    }


    private boolean isValidSearchCriteria(SearchCriteria criteria) {
        boolean valid = true;

        if (criteria == null)
            valid = false;
        else if (criteria.getCityA().equals(""))
            valid = false;
        else if (criteria.getCityB().equals(""))
            valid = false;
        else if (criteria.getDistance() <= 0)
            valid = false;

        return valid;
    }

    private CityDistance buildCityDistance(SearchCriteria criteria) {
        CityDistance cityDistance = new CityDistance();

        if (criteria.getId() != 0) {
            cityDistance.setId(criteria.getId());
        }
        cityDistance.setCityA(criteria.getCityA());
        cityDistance.setCityB(criteria.getCityB());
        cityDistance.setDistance(criteria.getDistance());

        return cityDistance;
    }

}
