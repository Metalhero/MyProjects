package io.portfolio.application.controller;

import io.portfolio.application.domain.Country;
import io.portfolio.application.domain.Location;
import io.portfolio.application.domain.State;
import io.portfolio.application.service.CountryService;
import io.portfolio.application.service.LocationService;
import io.portfolio.application.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LocationController {

    private StateService stateService;
    private CountryService countryService;
    private LocationService locationService;

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @Autowired
    public void setStateService(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/locations")
    private String getLocations(Model model){
        List<State> stateList= stateService.getStates();
        List<Country> countryList=countryService.getCountries();
        List<Location> locationList=locationService.getLocations();

        model.addAttribute("allstates",stateList);
        model.addAttribute("countries",countryList);
        model.addAttribute("locations",locationList);
        return "location";
    }

    @PostMapping("locations/addNew")
    public String addNew(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @GetMapping("locations/findById")
    @ResponseBody
    public Location findById(Long id){
        return locationService.findById(id);
    }

    @RequestMapping(value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location) {
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/delete",method = {RequestMethod.PUT, RequestMethod.GET})
    public String delete(Long id) {
        locationService.delete(id);
        return "redirect:/locations";
    }

}
