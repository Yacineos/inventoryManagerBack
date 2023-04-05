package com.yacineDev.demo.module;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Embeddable
public class FournitId implements Serializable {

    @Column(name="idF")
    private Long idF;

    @Column(name="dateF")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateF;

    @Column(name="id_produit")
    private Long id_produit;

    public FournitId() {
    }

    public FournitId(Long idF, Date dateF, Long id_produit) {
        this.idF = idF;
        this.dateF = dateF;
        this.id_produit = id_produit;
    }

    public Long getIdF() {
        return idF;
    }

    public void setIdF(Long idF) {
        this.idF = idF;
    }

    public Date getDateF() {
        return dateF;
    }

    public void setDateF(Date dateF) {
        this.dateF = dateF;
    }

    public Long getId_produit() {
        return id_produit;
    }

    public void setId_produit(Long id_produit) {
        this.id_produit = id_produit;
    }
}
