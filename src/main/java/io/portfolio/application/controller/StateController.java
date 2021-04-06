package io.portfolio.application.controller;

import io.portfolio.application.domain.Country;
import io.portfolio.application.domain.State;
import io.portfolio.application.service.CountryService;
import io.portfolio.application.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StateController {


    private StateService stateService;
    private CountryService countryService;

    @Autowired
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @Autowired
    public void setStateService(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/states")
    private String getStates(Model model){
        List<State> stateList=stateService.getStates();
        model.addAttribute("allstates",stateList);
        List<Country> countryList=countryService.getCountries();
        model.addAttribute("countries",countryList);
        return "state";
    }

    @PostMapping("states/addNew")
    public String addNew(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @GetMapping("states/findById")
    @ResponseBody
    public State findById(Long id){
        return stateService.findById(id);
    }

    @RequestMapping(value = "/states/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(State state) {
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "/states/delete",method = {RequestMethod.PUT, RequestMethod.GET})
    public String delete(Long id) {
        stateService.delete(id);
        return "redirect:/states";
    }


}
