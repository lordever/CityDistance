package com.Spring.City.controller;

import com.Spring.City.jsonview.Views;
import com.Spring.City.model.AjaxResponseBody;
import com.Spring.City.model.CalcCriteria;
import com.Spring.City.model.CityDistance;
import com.Spring.City.service.CityService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CalcDistanceRestController {
    private CityService cityService;
    private List<CityDistance> cities;

    @Autowired
    @Qualifier(value = "cityService")
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "calcDistance", method = RequestMethod.GET)
    public ModelAndView getCities(Model model) {
        ModelAndView modelAndView = new ModelAndView("calcDistance");
        cities = cityService.getCities();
        model.addAttribute("city", new CityDistance());
        model.addAttribute("cities", cities);
        return modelAndView;
    }

    @JsonView(value = Views.Public.class)
    @RequestMapping(value = "/calc")
    public AjaxResponseBody calcDistance(@RequestBody CalcCriteria calcCriteria) {
        AjaxResponseBody result = new AjaxResponseBody();

        if (isValidCriteria(calcCriteria)) {
            if (cityService.isExistCity(calcCriteria.getCityA(), calcCriteria.getCityB())) {
                result.setCode("200");
                result.setMessage(calcCriteria.getCityA() + " and " + calcCriteria.getCityB() + " exist in database");
            }
            else{
                result.setCode("402");
                result.setMessage(calcCriteria.getCityA() + " and " + calcCriteria.getCityB() + " not exist in database");
            }
        }

        return result;
    }

    private boolean isValidCriteria(CalcCriteria calcCriteria) {
        boolean isValid = true;

        if (calcCriteria.getCityA().equals("") || calcCriteria.getCityA().equals("")) {
            isValid = false;
        }

        return isValid;
    }
}
