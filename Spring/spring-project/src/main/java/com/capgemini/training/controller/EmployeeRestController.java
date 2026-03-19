package com.capgemini.training.controller;

import java.util.List;

import com.capgemini.training.Entity.Employee;
import com.capgemini.training.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeServices employeeServices;

    @GetMapping("/allemp")
    public List<Employee> getAllEmployees() {
        return employeeServices.getAllEmployee();
    }

    @GetMapping("/getemp/{id}")
    public Employee getSingleEmployee(@PathVariable int id) {
        return employeeServices.getEmployeeById(id);
    }
    @PostMapping("/createemp")
    public Employee registerEmp(@RequestBody Employee emp) {
        return employeeServices.saveEmployee(emp);
    }

    @PostMapping("/updateemp/{empId}")
    public Employee updateEmpByEmpId(@PathVariable int empId, @RequestBody Employee emp) {
        Employee existingEmp = employeeServices.getEmployeeByEmpId(empId);
        if (existingEmp == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found for empId: " + empId);
        }

        existingEmp.setEmpId(empId);
        existingEmp.setEmpName(emp.getEmpName());
        existingEmp.setEmpEmail(emp.getEmpEmail());
        existingEmp.setEmpContactNo(emp.getEmpContactNo());
        existingEmp.setEmpCity(emp.getEmpCity());

        return employeeServices.updateEmployee(existingEmp);
    }
}
