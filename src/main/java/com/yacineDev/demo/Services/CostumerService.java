package com.yacineDev.demo.Services;

import com.yacineDev.demo.Repositories.CostumerRepo;
import com.yacineDev.demo.exception.CostumerNotFoundException;
import com.yacineDev.demo.module.Costumer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class CostumerService {
    private final CostumerRepo costumerRepo;


    @Autowired
    public CostumerService(CostumerRepo costumerRepo) {
        this.costumerRepo= costumerRepo;
    }
    @Transactional
    public Costumer addCostumer(String nom, String prenom, String email, int nTel, int numRue, String nomRue, int codePostal, String ville){
         costumerRepo.addCostumer(nom,prenom,email,nTel,numRue,nomRue,codePostal,ville);
        return null ;
    }
    @Transactional
    public List<Costumer> findAllCostumers(){
        return costumerRepo.findAllClient() ;
    }
    @Transactional
    public List<Costumer> findAllCostumersOrderedByName(){
        return costumerRepo.findAllClientOrderedByName();
    }
    @Transactional
    public List<Costumer> findAllCostumersOrderedByNameDESC(){
        return costumerRepo.findAllClientOrderedByNameDESC();
    }

    @Transactional
    public List<Costumer> findAllCostumersOrderedByEmail(){
        return costumerRepo.findAllClientOrderedByEmail();
    }
    @Transactional
    public List<Costumer> findAllCostumersOrderedByEmailDESC(){
        return costumerRepo.findAllClientOrderedByEmailDESC();
    }
    @Transactional
    public List<Costumer> findAllClientsByIdOrPhone(long idOrPhone){
        return costumerRepo.findCostumersByIdOrPhone(idOrPhone);
    }
    @Transactional
    public List<Costumer> findCostumersByInput(String input){
        return costumerRepo.findCostumersByInput(input);
    }
    @Transactional
    public  Costumer updateCostumer(Costumer costumer){
        costumerRepo.updateCostumer(costumer.getNom(),costumer.getPrenom(),costumer.getEmail(),parseInt(costumer.getnTel()),costumer.getNumRue(),costumer.getNomRue(),costumer.getCodePostal(),costumer.getVille(),costumer.getId());
        return null;
    }
    @Transactional
    public Costumer findCostumerById(Long id)  {
        return costumerRepo.findCostumerById(id).orElseThrow(() -> new CostumerNotFoundException("Costumer By id : "+id+" was not found "));
    }
    @Transactional
    public void deleteCostumer(Long id){
        costumerRepo.deleteCostumerById(id);
    }
}
