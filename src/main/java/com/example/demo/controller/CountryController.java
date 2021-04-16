package com.example.demo.controller;

import com.example.demo.domain.Country;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CountryController {

    private CountryService countryService;

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    private String getCountries(Model model){
        List<Country> countryList=countryService.getCountries();
        model.addAttribute("allcountries",countryList);
        return "country";
    }

    @PostMapping("countries/addNew")
    public String addNew(Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }

    @GetMapping("countries/findById")
    @ResponseBody
    public Country findById(Long id){
        return countryService.findById(id).get();
    }

    @RequestMapping(value = "/countries/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Country country) {
        countryService.save(country);
        return "redirect:/countries";
    }

    @RequestMapping(value = "/countries/delete",method = {RequestMethod.PUT, RequestMethod.GET})
    public String delete(Long id) {
        countryService.delete(id);
        return "redirect:/countries";
    }
}