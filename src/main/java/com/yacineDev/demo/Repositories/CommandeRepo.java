package com.yacineDev.demo.Repositories;

import com.yacineDev.demo.module.Commande;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public interface CommandeRepo extends JpaRepository<Commande,Long> {

    @Query(value="SELECT * FROM commande",nativeQuery = true)
    List<Commande> findAllCommande();

    @Modifying
    @Transactional
    @Query(value="INSERT INTO commande (date_commande , id_client , idE) VALUES (?1,?2,?3)",nativeQuery = true)
    void addCommande(Date date_commande , Long id_client , Long idE, Long id_commande );

    @Modifying
    @Transactional
    @Query(value="UPDATE commande SET id_client = ?2 , idE = ?3 WHERE id_commande = ?1",nativeQuery = true)
    void modifyCommande(Long id_commande , Long id_client , Long idE);
    @Query(value="SELECT MAX(id_commande) FROM commande",nativeQuery = true)
    int findLastId();

    @Query(value="SELECT id_client FROM commande WHERE id_commande = ?1",nativeQuery = true)
    int findIdClientByIdCommande(Long id_commande);
}
