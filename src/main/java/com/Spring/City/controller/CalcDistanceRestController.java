package com.Spring.City.controller;

import com.Spring.City.algoritm.TestDijkstraAlgorithm;
import com.Spring.City.algoritm.Vertex;
import com.Spring.City.model.CityDistance;
import com.Spring.City.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

@Controller
public class CalcDistanceRestController {
    private CityService cityService;
    private LinkedList<Vertex> path;

    @Autowired
    @Qualifier(value = "cityService")
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "calcDistance", method = RequestMethod.GET)
    public String cities(Model model) {
        model.addAttribute("city", new CityDistance());
        model.addAttribute("cities", this.cityService.getCities());

        return "calcDistance";
    }

    @RequestMapping(value = "rest/calc", method = RequestMethod.POST)
    public @ResponseBody Integer calcCityDistance(@RequestBody CityDistance cityDistance){
        String fromCity = cityDistance.getCityA();
        String toCity = cityDistance.getCityB();
        List<CityDistance> cities = cityService.getCities();
        TestDijkstraAlgorithm dijkstraAlgorithm = new TestDijkstraAlgorithm(fromCity, toCity);
        dijkstraAlgorithm.execute(cities);
        path = dijkstraAlgorithm.getPath();
        return dijkstraAlgorithm.getMinDistance();
    }

    @RequestMapping(value = "/rest/path", method = RequestMethod.GET)
    public @ResponseBody LinkedList<Vertex> getPath() {
        return path;
    }
}
