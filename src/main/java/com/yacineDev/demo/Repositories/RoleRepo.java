package com.yacineDev.demo.Repositories;

import com.yacineDev.demo.module.Costumer;
import com.yacineDev.demo.module.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Long> {

    @Query(value = "SELECT * FROM role", nativeQuery = true)
    List<Role> findAllrole();

    @Query(value = "SELECT nomR FROM role WHERE idR = ?1", nativeQuery = true)
    String findRoleById(Long id);

    @Query(value = "SELECT idR FROM concerne WHERE idE = ?1 ", nativeQuery = true)
    Optional<Integer> findRoleByIdEmployee(Long id);



}
