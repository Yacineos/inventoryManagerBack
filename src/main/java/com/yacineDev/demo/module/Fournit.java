package com.yacineDev.demo.module;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="fournit")
public class Fournit {

    @Id
    private FournitId id;


    @Column(name="qte_produit")
    private int qte_produit;



    public Fournit() {
    }

    public Fournit(FournitId id, int qte_produit) {
        this.id = id;
        this.qte_produit = qte_produit;
    }

    public FournitId getId() {
        return id;
    }

    public void setId(FournitId id) {
        this.id = id;
    }

    public int getQte_produit() {
        return qte_produit;
    }

    public void setQte_produit(int qte_produit) {
        this.qte_produit = qte_produit;
    }
}
