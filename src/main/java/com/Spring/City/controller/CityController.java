package com.Spring.City.controller;

import com.Spring.City.model.CityDistance;
import com.Spring.City.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CityController {
    private CityService cityService;

    @Autowired
    @Qualifier(value = "cityService")
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "cities", method = RequestMethod.GET)
    public String cities(Model model) {
        model.addAttribute("city", new CityDistance());
        model.addAttribute("cities", this.cityService.getCities());

        return "cities";
    }

    @RequestMapping("edit/{id}")
    public String updateCity(@PathVariable("id") long id, Model model) {
        model.addAttribute("city", this.cityService.getCityById(id));
        model.addAttribute("cities", this.cityService.getCities());

        return "cities";
    }
}
