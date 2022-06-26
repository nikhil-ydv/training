package com.consultadd.service;

import com.consultadd.model.Employee;
import com.consultadd.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {

        return employeeRepository.findAll();
    }
    //New Data
    public String saveEmployee(Employee employee) {
        if(employeeRepository.existsById(employee.getId())) {
            return "Couldn't save data. Id already exits";
        }
        else {
            employeeRepository.save(employee);
            return "Employee data saved successfully";
        }
    }



    // updating record
    public String updateEmp(Employee employee, String id) {
        List<Employee> e = employeeRepository.findAll();
        int i = -1;
        for (Employee t : e) {
            if (t.getId().equals(id)) {
                i++;
            }
        }
        if (i == -1) {
            return "Data doesn't exist";
        }
        employeeRepository.save(employee);
        return "EmpData with Id: "+id+" is updated";
    }

    //delete record
    public String deleteEmployee(String id) {
        List<Employee> e = employeeRepository.findAll();
        String ans = "";
        for (Employee t : e) {
            if (t.getId().equals(id)) {
                ans = t.getId();
            }
        }
        employeeRepository.deleteById(ans);
        if (ans.length()>0) {
            return "Data deleted successfully";
        }
        return "Data doesn't exist";
    }

}
