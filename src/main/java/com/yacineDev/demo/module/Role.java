package com.yacineDev.demo.module;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idR", nullable = false, updatable = false)
    private Long idR;
    @Column(name = "nomR")
    private String nomR;

    public Role(Long idR) {
        this.idR = idR;
        this.nomR = nomR;
    }

    public Role() {

    }

    public Long getIdR() {
        return idR;
    }

    public String getNomR() {
        return nomR;
    }

    public void setIdR(Long idR) {
        this.idR = idR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

}
