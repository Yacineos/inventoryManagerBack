package com.yacineDev.demo.Services;

import com.yacineDev.demo.Repositories.RoleRepo;
import com.yacineDev.demo.module.Costumer;
import com.yacineDev.demo.module.Role;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepo roleRepo ;

    @Autowired
    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }
    @Transactional
    public List<Role> findAllRole(){
        return roleRepo.findAllrole() ;
    }

}
