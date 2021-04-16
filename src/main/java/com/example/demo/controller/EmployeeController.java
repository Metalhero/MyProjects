package com.example.demo.controller;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    private String getEmployees(Model model){
        model.addAttribute("employees", employeeService.getEmployees());
        return "employee";
    }

    @PostMapping("/employees/addNew")
    private String addNew(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping("employees/findById")
    @ResponseBody
    private Employee findById (Long id) {
        return employeeService.findById(id);
    }

    @RequestMapping(value = "employees/update", method =  {RequestMethod.PUT, RequestMethod.GET})
    private String update(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "employees/delete", method =  {RequestMethod.DELETE, RequestMethod.GET})
    private String delete(Long id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
