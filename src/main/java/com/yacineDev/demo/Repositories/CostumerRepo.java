package com.yacineDev.demo.Repositories;

import com.yacineDev.demo.module.Costumer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CostumerRepo extends JpaRepository<Costumer,Long> {

    Optional<Costumer> findCostumerById(Long id);

    @Query(value = "SELECT * FROM client",nativeQuery = true)
    List<Costumer> findAllClient();

    @Query(value="SELECT * FROM client ORDER BY nom",nativeQuery = true)
    List<Costumer> findAllClientOrderedByName();

    @Query(value="SELECT * FROM client ORDER BY nom DESC",nativeQuery = true)
    List<Costumer> findAllClientOrderedByNameDESC();


    @Query(value="SELECT * FROM client ORDER BY email DESC",nativeQuery = true)
    List<Costumer> findAllClientOrderedByEmailDESC();


    @Query(value="SELECT * FROM client ORDER BY email",nativeQuery = true)
    List<Costumer> findAllClientOrderedByEmail();

    @Query(value="SELECT * FROM client WHERE nom LIKE %?1% OR prenom LIKE %?1% OR email LIKE %?1%",nativeQuery = true)
    List<Costumer> findCostumersByInput(String input);

    @Query(value="SELECT * FROM client WHERE n_tel = ?1 OR id= ?1 ",nativeQuery = true)
    List<Costumer> findCostumersByIdOrPhone(long idOrPhone);
    @Modifying
    @Transactional
    @Query(value="DELETE FROM client WHERE id = ?1",nativeQuery = true)
    void deleteCostumerById(Long id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO client (nom,prenom,email,n_tel,num_rue,nom_rue,code_postal,ville) VALUES (?1,?2,?3,?4,?5,?6,?7,?8)",nativeQuery = true)
    void addCostumer(String nom,String prenom,String email,int nTel,int numRue,String nomRue,int codePostal,String ville);

    @Modifying
    @Transactional
    @Query(value="UPDATE client SET nom = ?1,prenom = ?2,email = ?3,n_tel = ?4,num_rue = ?5,nom_rue = ?6,code_postal = ?7,ville = ?8 WHERE id = ?9",nativeQuery = true)
    void updateCostumer(String nom,String prenom,String email,int nTel,int numRue,String nomRue,int codePostal,String ville,Long id);
  }
