package com.yacineDev.demo.module;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name="fournit")
public class Fournit {
    @Id
    @Column(name="idF")
    private Long idF;

    @Column(name="id_produit")
    private int idProduit;

    @Column(name="qte_produit")
    private int qte_produit;

    @Column(name="dateF")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateF;

    public Fournit() {
    }

    public Fournit(Long idF, int idProduit, int qte_produit, Date dateF) {
        this.idF = idF;
        this.idProduit = idProduit;
        this.qte_produit = qte_produit;
        this.dateF = dateF;
    }

    public Long getIdF() {
        return idF;
    }

    public void setIdF(Long idF) {
        this.idF = idF;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getQte_produit() {
        return qte_produit;
    }

    public void setQte_produit(int qte_produit) {
        this.qte_produit = qte_produit;
    }

    public Date getDateF() {
        return dateF;
    }

    public void setDateF(Date dateF) {
        this.dateF = dateF;
    }
}
