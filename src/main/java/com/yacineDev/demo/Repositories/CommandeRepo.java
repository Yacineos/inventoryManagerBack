package com.yacineDev.demo.Repositories;

import com.yacineDev.demo.module.Commande;
import com.yacineDev.demo.module.CommandeDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.RowMapper;

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

    @Query(value = "SELECT produit.id_produit as id, produit.nom as nom , produit.prix_unitaire as prix , contient.qte_produit as qte , (produit.prix_unitaire * contient.qte_produit) as total FROM produit JOIN contient ON contient.id_produit=produit.id_produit JOIN commande ON commande.id_commande = contient.id_commande WHERE commande.id_commande= ?1" ,nativeQuery = true)
    List<?> getCommandeInformation_Named(Long id_commande);
}
