package com.consultadd.controller;

import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;
import com.consultadd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    //controller ->  service(business logic -> repository

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployee() {
        List<Employee> employeeList = employeeService.getEmployees();
        return employeeList;

    }
    @PostMapping("/addemp")
    //Data being passed from body to this method, we need to bind that data to this method
    // RequestBody annotation before parameter to be binded
    // Serialization is being used here to convert body data to object being passed in the method
    //Serialization: Object -> Bytes & Bytes -> Objects
    //String is just Bytes
    public String saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employee/{id}")
    public String updateEmp(@RequestBody Employee employee, @PathVariable String id){
        return employeeService.updateEmp(employee,id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id){
        return employeeService.deleteEmployee(id);
    }


}
