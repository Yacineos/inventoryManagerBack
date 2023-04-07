package com.yacineDev.demo.Controller;

import com.yacineDev.demo.Services.EmployeeService;
import com.yacineDev.demo.module.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    @GetMapping("/all/nameAsc")
    public ResponseEntity<List<Employee>> getAllEmployeesOrderedByName(){
        List<Employee> employees = employeeService.findAllEmployeesOrderedByName();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    @GetMapping("/all/nameDesc")
    public ResponseEntity<List<Employee>> getAllEmployeesOrderedByNameDESC(){
        List<Employee> employees = employeeService.findAllEmployeesOrderedByNameDESC();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    @GetMapping("/all/emailAsc")
    public ResponseEntity<List<Employee>> getAllEmployeesOrderedByEmail(){
        List<Employee> employees = employeeService.findAllEmployeesOrderedByEmail();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    @GetMapping("/all/emailDesc")
    public ResponseEntity<List<Employee>> getAllEmployeesOrderedByEmailDESC(){
        List<Employee> employees = employeeService.findAllEmployeesOrderedByEmailDESC();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    @GetMapping("/findEmployees/{input}")
    public ResponseEntity<List<Employee>> getEmployeeByInput(@PathVariable("input") String input) {
        List<Employee> employees = employeeService.findEmployeesByInput(input);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
    @GetMapping("/find/role/{id}")
    public ResponseEntity<String> getEmployeeRole(@PathVariable("id") BigInteger id){
        String role = employeeService.getEmployeeRole(id);
        return new ResponseEntity<>(role,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = null;
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
