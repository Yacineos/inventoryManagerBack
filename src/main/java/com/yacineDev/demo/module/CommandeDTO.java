package com.yacineDev.demo.module;

public class CommandeDTO {
    private Long id_produit;
    private String nom ;
    private float prix_unitaire;
    private int qte_produit;
    private float totalValue ;

    public CommandeDTO(){}
    public CommandeDTO(Long id_produit, String nom, float prix_unitaire, int qte_produit, float totalValue) {
        this.id_produit = id_produit;
        this.nom = nom;
        this.prix_unitaire = prix_unitaire;
        this.qte_produit = qte_produit;
        this.totalValue = totalValue;
    }

    public Long getId_produit() {
        return id_produit;
    }

    public void setId_produit(Long id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public int getQte_produit() {
        return qte_produit;
    }

    public void setQte_produit(int qte_produit) {
        this.qte_produit = qte_produit;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }
}
