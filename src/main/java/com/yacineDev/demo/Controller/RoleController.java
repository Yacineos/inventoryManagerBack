package com.yacineDev.demo.Controller;

import com.yacineDev.demo.Services.RoleService;
import com.yacineDev.demo.module.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService ;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Role>> getallRole() {
        List<Role> roles = roleService.findAllRole();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

}
