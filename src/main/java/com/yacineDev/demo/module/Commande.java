package com.yacineDev.demo.module;

import jakarta.persistence.*;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="commande")
public class Commande implements Serializable {
    @Id
    @Column(name="id_commande")
    private Long id_commande;

    @Column(name="date_commande")
    private Date date_commande;

    @Column(name="id_client")
    private Long id_client;

    @Column(name="idE")
    private Long idE;

    public Commande(Long id_commande, Date date_commande, Long id_client, Long idE) {
        this.id_commande = id_commande;
        this.date_commande = date_commande;
        this.id_client = id_client;
        this.idE = idE;
    }

    public Commande() {
    }

    public Long getId_commande() {
        return id_commande;
    }

    public void setId_commande(Long id_commande) {
        this.id_commande = id_commande;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public Long getIdE() {
        return idE;
    }

    public void setIdE(Long idE) {
        this.idE = idE;
    }
}
