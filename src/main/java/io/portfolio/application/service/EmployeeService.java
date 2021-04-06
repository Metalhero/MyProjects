package io.portfolio.application.service;

import io.portfolio.application.domain.Employee;
import io.portfolio.application.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void save(Employee client) {
        employeeRepository.save(client);
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

}