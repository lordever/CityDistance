package com.Spring.City.controller;

import com.Spring.City.model.CityDistance;
import com.Spring.City.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
public class CityController {
    private CityService cityService;

    @Autowired
    @Qualifier(value = "cityService")
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    //AJAX + Spring part
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String printWelcome() {
        return "hello";
    }

    @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
    @ResponseBody
    public Set<String> ajaxTest() {
        Set<String> records = new HashSet<String>();
        records.add("Record #1");
        records.add("Record #2");

        return records;
    }
    //AJAX + Spring part

    @RequestMapping(value = "cities", method = RequestMethod.GET)
    public String cities(Model model) {
        model.addAttribute("city", new CityDistance());
        model.addAttribute("cities", this.cityService.getCities());

        return "cities";
    }

    @RequestMapping(value = "/cities/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("city") CityDistance city) {
        if (city.getId() == 0) {
            this.cityService.addCity(city);
        }
        return "redirect:/cities";
    }

    @RequestMapping("/remove/{id}")
    public String removeCity(@PathVariable(value = "id") long id) {
        this.cityService.removeCity(id);

        return "redirect:/cities";
    }

    @RequestMapping("edit/{id}")
    public String editCity(@PathVariable("id") long id, Model model) {
        model.addAttribute("city", this.cityService.getCityById(id));
        model.addAttribute("cities", this.cityService.getCities());

        return "cities";
    }
}
