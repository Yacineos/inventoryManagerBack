package com.yacineDev.demo.Repositories;

import com.yacineDev.demo.module.Contient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContientRepo extends JpaRepository<Contient,Long> {

    @Query(value="SELECT qte_produit FROM contient",nativeQuery = true)
    List<Integer> testGetAllContient();
    @Query(value="SELECT qte_produit,id_commande,id_produit FROM contient",nativeQuery = true)
    List<Contient> g();
    @Query(value="SELECT * FROM contient WHERE id_commande = ?1",nativeQuery = true)
    List<Contient> findContientByIdCommande(Long id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO contient (id_commande , id_produit , qte_produit) VALUES (?1,?2,?3)" , nativeQuery = true)
    void addContient(Long id_commande , Long id_produit , int quantite);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM contient WHERE id_commande = ?1",nativeQuery = true)
    void deleteContientByIdCommande(Long id);

    @Modifying
    @Transactional
    @Query(value="UPDATE contient SET qte_produit = ?1 WHERE id_commande = ?2 AND id_produit = ?3",nativeQuery = true)
    void updateContient(int quantite,Long id_commande,Long id_produit);
}
