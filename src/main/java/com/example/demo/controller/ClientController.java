package com.example.demo.controller;

import com.example.demo.domain.Client;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    private String getCountries(Model model){
        model.addAttribute("clients", clientService.getClients());
        return "client";
    }

    @PostMapping("/clients/addNew")
    private String addNew(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping("clients/findById")
    @ResponseBody
    private Client findById (Long id) {
        return clientService.findById(id);
    }

    @RequestMapping(value = "clients/update", method =  {RequestMethod.PUT, RequestMethod.GET})
    private String update(Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "clients/delete", method =  {RequestMethod.DELETE, RequestMethod.GET})
    private String delete(Long id) {
        clientService.delete(id);
        return "redirect:/clients";
    }






}
