package com.yacineDev.demo.Repositories;

import com.yacineDev.demo.module.Fournit;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface FournitRepo extends JpaRepository<Fournit,Long>{

    @Modifying
    @Transactional
    @Query(value="INSERT INTO fournit (idF , id_produit , qte_produit , dateF ) VALUES (?1,?2,?3,?4) ",nativeQuery = true)
    void addFournit(Long idF,Long idP , int quantite , LocalDate date);

    @Query(value="SELECT * FROM fournit",nativeQuery = true)
    List<Fournit> findAllFournit();
}
