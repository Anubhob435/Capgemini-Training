package com.capgemini.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.capgemini.training.Entity.Employee;
import com.capgemini.training.services.EmployeeServices;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeServices employeeServices;

    @GetMapping("/all")
    public String getAllEmployees(Model model) {
        List<Employee> list = employeeServices.getAllEmployee();
        model.addAttribute("employees", list);
        return "/employeeList.jsp";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "/addEmployee.jsp";
    }

    @PostMapping("/add")
    public String addEmployee(Employee employee) {
        employeeServices.saveEmployee(employee);
        return "redirect:/employee/all";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Employee emp = employeeServices.getEmployeeById(id);
        model.addAttribute("employee", emp);
        return "/editEmployee.jsp";
    }

    @PostMapping("/update")
    public String updateEmployee(Employee employee) {
        employeeServices.updateEmployee(employee);
        return "redirect:/employee/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeServices.deleteEmployee(id);
        return "redirect:/employee/all";
    }
}