package com.Spring.City.controller;

import com.Spring.City.model.CityDistance;
import com.Spring.City.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class CityRestController {

    private CityService cityService;

    @Autowired
    @Qualifier(value = "cityService")
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "cities", method = RequestMethod.GET)
    public String cities() {
        return "cities";
    }

    @RequestMapping(value = "rest/getCitiesForRedactor", method = RequestMethod.GET)
    public @ResponseBody List<CityDistance> getCities() {
        return cityService.getCities();
    }

    @RequestMapping(value = "rest/add", method = RequestMethod.POST)
    public @ResponseBody CityDistance addCity(@RequestBody CityDistance cityDistance) {
        if(isValid(cityDistance)){
            this.cityService.addCity(cityDistance);
        }
        return cityDistance;
    }

    @RequestMapping(value = "rest/get/{id}", method = RequestMethod.GET)
    public @ResponseBody CityDistance getCity(@PathVariable(value = "id") long id) {
        return cityService.getCityById(id);
    }

    @RequestMapping(value = "rest/edit", method = RequestMethod.PUT)
    public @ResponseBody CityDistance updateCity(@RequestBody CityDistance cityDistance) {
        if(isValid(cityDistance)){
            this.cityService.updateCity(cityDistance);
        }
        return cityDistance;
    }

    @RequestMapping(value = "rest/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody CityDistance removeCity(@PathVariable(value = "id") long id) throws IOException {
        this.cityService.removeCity(id);

        return new CityDistance();
    }

    private boolean isValid(CityDistance cityDistance) {
        boolean valid = true;

        if (cityDistance == null)
            valid = false;
        else if (cityDistance.getCityA().equals(""))
            valid = false;
        else if (cityDistance.getCityB().equals(""))
            valid = false;
        else if (cityDistance.getDistance() <= 0)
            valid = false;

        return valid;
    }

}
