package com.yacineDev.demo.module;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="employee")
public class Employee implements Serializable {
    @Id
    @Column(name="idE")
    private Long idE;
    @Column(name = "email")
    private String email;
    @Column(name = "nom")
    private String nom ;
    @Column(name = "prenom")
    private String prenom;
    @Column(name="n_tel")
    private String nTel;

    @Column(name="nom_utilisateur")
    private String nomUtilisateur;

    @Column(name="mot_de_passe")
    private String motDePasse;

    @Column(name="numero_rue")
    private Integer numRue;

    @Column(name="nom_rue")
    private String nomRue;

    @Column(name="code_postal")
    private int codePostal;

    @Column(name="ville")
    private String ville;

    @Column(name="id_manager")
    private Long id_manager;

    public Employee(){

    }

    public Employee(Long idE, String email, String nom, String prenom, String nTel, String nomUtilisateur, String motDePasse, Integer numRue, String nomRue, int codePostal, String ville, Long id_manager) {
        this.idE = idE;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.nTel = nTel;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.numRue = numRue;
        this.nomRue = nomRue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.id_manager = id_manager;
    }

    public Long getIdE() {
        return idE;
    }

    public void setIdE(Long idE) {
        this.idE = idE;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName   () {
        return nom;
    }

    public void setName(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getnTel() {
        return nTel;
    }

    public void setnTel(String nTel) {
        this.nTel = nTel;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Integer getNumRue() {
        return numRue;
    }

    public void setNumRue(Integer numRue) {
        this.numRue = numRue;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Long getId_manager() {
        return id_manager;
    }

    public void setId_manager(Long id_manager) {
        this.id_manager = id_manager;
    }
}
