package com.yacineDev.demo.module;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ContientId implements Serializable {

    @Column(name = "id_commande")
    private Long idCommande;

    @Column(name = "id_produit")
    private Long idProduit;

    // constructors, getters and setters

    ContientId() {
    }

    public ContientId(Long idCommande, Long idProduit) {
        this.idCommande = idCommande;
        this.idProduit = idProduit;
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }
}
