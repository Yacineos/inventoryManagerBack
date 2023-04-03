package com.yacineDev.demo.module;

import jakarta.persistence.*;

@Entity
@Table(name="contient")
public class Contient {

    @EmbeddedId
    private ContientId id;

    @Column(name="qte_produit")
    private int qte_produit;


    public Contient() {
    }

    public Contient(ContientId id, int qte_produit) {
        this.id = id;
        this.qte_produit = qte_produit;
    }

    public ContientId getId() {
        return id;
    }

    public void setId(ContientId id) {
        this.id = id;
    }

    public int getQte_produit() {
        return qte_produit;
    }

    public void setQte_produit(int qte_produit) {
        this.qte_produit = qte_produit;
    }
}
