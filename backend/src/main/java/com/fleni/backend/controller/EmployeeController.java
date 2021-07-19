
package com.fleni.backend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fleni.backend.model.Employee;
import com.fleni.backend.repository.EmployeeRepository;
import com.fleni.backend.exception.employee.EmployeeNotFoundException;
import com.fleni.backend.model.Address;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController @CrossOrigin(origins = "*")
class EmployeeController {

    @Autowired
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }
  
    @GetMapping("/employees/{id}")
    public Employee getById(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
    
    @GetMapping("/employees/search/{text}")
    public List<Employee> search(@PathVariable String text) {
        return repository.findAll()
                .stream()
                .filter(p -> p.toString().contains(text))
                .collect(Collectors.toList());
    }

    @PutMapping("/employees/{id}")
    public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {      
        return repository.findById(id)
            .map(employee -> {
                employee.setFirstName(newEmployee.getFirstName());
                employee.setLastName(newEmployee.getLastName());
                employee.setEmail(newEmployee.getEmail());
                employee.setPhoneNumber(newEmployee.getPhoneNumber());
                employee.setHireDate(newEmployee.getHireDate());
                employee.setSalary(newEmployee.getSalary());
                employee.setCommissionPct(newEmployee.getCommissionPct());
                return repository.save(employee);
            })
            .orElseGet(() -> {
                return repository.save(newEmployee);
            });
    }
    
    @PutMapping("/employees/{id}/address")
    public Employee addAddress(@RequestBody Address newAddress, @PathVariable Long id) { 
        Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        List<Address> addresses = employee.getAddresses();
        addresses.add(newAddress);
        employee.setAddresses(addresses);
        return repository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}