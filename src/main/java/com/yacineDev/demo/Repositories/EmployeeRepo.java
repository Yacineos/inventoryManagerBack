package com.yacineDev.demo.Repositories;

import com.yacineDev.demo.module.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    @Modifying
    @Transactional
    @Query(value="DELETE FROM employee WHERE idE = ?1",nativeQuery = true)
    void deleteEmployeeById(Long id);

    @Query(value = "SELECT * FROM employee",nativeQuery = true)
    List<Employee> findAllEmployees();

    @Query(value="SELECT * FROM employee ORDER BY nom",nativeQuery = true)
    List<Employee> findAllEmployeesOrderedByName();

    @Query(value="SELECT * FROM employee ORDER BY nom DESC",nativeQuery = true)
    List<Employee> findAllEmployeesOrderedByNameDESC();


    @Query(value="SELECT * FROM employee ORDER BY email DESC",nativeQuery = true)
    List<Employee> findAllEmployeesOrderedByEmailDESC();


    @Query(value="SELECT * FROM employee ORDER BY email",nativeQuery = true)
    List<Employee> findAllEmployeesOrderedByEmail();

    @Query(value="SELECT * FROM employee WHERE nom_utilisateur LIKE %?1% OR nom LIKE %?1% OR prenom LIKE %?1% OR email LIKE %?1%",nativeQuery = true)
    List<Employee> findEmployeesByInput(String input);

    @Query(value="SELECT * FROM employee WHERE idE = ?1 AND mot_de_passe = ?2",nativeQuery = true)
    Optional<Employee> findByIdAndPassword(long idEmployee,String password);

    @Query(value="SELECT * FROM employee WHERE idE = ?1",nativeQuery = true)
    Optional<Employee> findEmployeeByIdE(long id);

    @Query(value="SELECT r.nomR FROM employee e JOIN concerne c ON e.idE= c.idE JOIN role r ON c.idR = r.idR WHERE e.idE = ?1",nativeQuery = true)
    String getEmployeeRole(BigInteger id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO employee (nom_utilisateur,mot_de_passe) VALUES (?1,?2)",nativeQuery = true)
    void addEmployee(String username,String password);

    @Modifying
    @Transactional
    @Query(value="UPDATE employee SET email = ?1,nom = ?2,prenom = ?3,n_tel = ?4,numero_rue = ?5,nom_rue = ?6,code_postal = ?7,ville = ?8 WHERE nom_utilisateur = ?9",nativeQuery = true)
    void updateEmployee(String email,String nom,String prenom,int nTel,int numRue,String nomRue,int codePostal,String ville,String username);
}
