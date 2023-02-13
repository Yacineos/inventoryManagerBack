package com.yacineDev.demo.Controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yacineDev.demo.Repositories.EmployeeRepo;
import com.yacineDev.demo.module.Employee;
import com.yacineDev.demo.module.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private EmployeeRepo employeeRepository;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        Optional<Employee> employee = employeeRepository.findByUsernameAndPassword(username, password);
        if (employee.isPresent()) {
            // Authentication successful, return success response
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            return response;
        } else {
            // Authentication failed, return error response
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Invalid username or password");
            return response;
        }
    }

}

