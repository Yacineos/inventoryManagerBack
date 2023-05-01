package com.yacineDev.demo.Services;

import com.yacineDev.demo.Repositories.ContientRepo;
import com.yacineDev.demo.module.Contient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContientService {

    private final ContientRepo contientRepo;

    @Autowired
    public ContientService(ContientRepo contientRepo) {
        this.contientRepo = contientRepo;
    }

    @Transactional
    public List<Contient> findAllContient(){
        for (   Contient contient : contientRepo.g()
             ){
            System.out.println(contient.toString());

        }
        return contientRepo.g();
    }
    @Transactional
    public List<Contient> findContientByIdCommande(Long id){
        return contientRepo.findContientByIdCommande(id);
    }

    @Transactional
    public void addContient(Long id_commande , Long id_produit , int quantite){
        contientRepo.addContient(id_commande , id_produit , quantite);
    }

    @Transactional
    public void deleteContientByIdCommande(Long id){
        contientRepo.deleteContientByIdCommande(id);
    }

    @Transactional
    public void updateContient(int quantite,Long id_commande,Long id_produit){
        contientRepo.updateContient(quantite,id_commande,id_produit);
    }

    @Transactional
    public int findNbElementByIdCommande(Long id){
        return contientRepo.findContientByIdCommande(id).size();
    }

    @Transactional
    public void deleteProductFromContientByIdCommandeAndIdProduit(Long id_commande,Long id_produit){
        contientRepo.deleteProductFromContientByIdCommandeAndIdProduit(id_commande,id_produit);
    }

}
