package com.yacineDev.demo.Services;

import com.yacineDev.demo.Repositories.EmployeeRepo;
import com.yacineDev.demo.exception.UserNotFoundException;
import com.yacineDev.demo.module.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import static java.lang.Integer.parseInt;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAllEmployees() ;
    }
    public List<Employee> findAllEmployeesOrderedByName(){
        return employeeRepo.findAllEmployeesOrderedByName();
    }
    public List<Employee> findAllEmployeesOrderedByNameDESC(){
        return employeeRepo.findAllEmployeesOrderedByNameDESC();
    }
    public List<Employee> findAllEmployeesOrderedByEmail(){
        return employeeRepo.findAllEmployeesOrderedByEmail();
    }
    public List<Employee> findAllEmployeesOrderedByEmailDESC(){
        return employeeRepo.findAllEmployeesOrderedByEmailDESC();
    }
    public List<Employee> findEmployeesByInput(String input){
        return employeeRepo.findEmployeesByInput(input);
    }

    public  void updateEmployee(Employee employee){
        employeeRepo.updateEmployee(employee.getEmail(),employee.getName(),employee.getPrenom(),parseInt(employee.getnTel()),employee.getNumRue(),employee.getNomRue(),employee.getCodePostal(),employee.getVille(),employee.getNomUtilisateur());
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }

    public String getEmployeeRole(BigInteger id){
        return employeeRepo.getEmployeeRole(id);
    }

    public List<?> getAllManagers(){
        return employeeRepo.findAllManagers();
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeByIdE(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }
}
