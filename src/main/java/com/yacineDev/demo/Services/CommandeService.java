package com.yacineDev.demo.Services;

import com.yacineDev.demo.Mapper.CommandeDTOMapper;
import com.yacineDev.demo.Repositories.CommandeRepo;
import com.yacineDev.demo.module.Commande;
import com.yacineDev.demo.module.CommandeDTO;
import com.yacineDev.demo.module.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeService {

    private final CommandeRepo commandeRepo;

    @Autowired
    public CommandeService(CommandeRepo commandeRepo) {
        this.commandeRepo = commandeRepo;
    }

    public List<Commande> findAllCommandes(){
        return commandeRepo.findAllCommande();
    }

    public void addCommande(Commande commande){
        Date currentDate = new Date();
        // create a SimpleDateFormat object with the desired format

        commandeRepo.addCommande(currentDate,commande.getId_client(),commande.getIdE(),commande.getId_commande());
    }
    public void modifyCommande(Commande commande){
        commandeRepo.modifyCommande(commande.getId_commande(),commande.getId_client(),commande.getIdE());
    }
    public int findLastId(){
        return commandeRepo.findLastId();
    }

    public int findIdClientByIdCommande(Long id_commande){
        return commandeRepo.findIdClientByIdCommande(id_commande);
    }
    public List<?> getCommandeInformation(Long id){
        List<?> test = commandeRepo.getCommandeInformation_Named(id);
        System.out.println("hello");
        return test;

    }


}
