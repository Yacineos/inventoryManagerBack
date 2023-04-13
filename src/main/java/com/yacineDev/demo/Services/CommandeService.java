package com.yacineDev.demo.Services;

import com.yacineDev.demo.Mapper.CommandeDTOMapper;
import com.yacineDev.demo.Repositories.CommandeRepo;
import com.yacineDev.demo.module.Commande;
import com.yacineDev.demo.module.CommandeDTO;
import com.yacineDev.demo.module.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public List<Double> statistics(){
        List<Double> statistics = new ArrayList<>();

        Double beneficeWeek = commandeRepo.beneficeLastWeek();
        if(beneficeWeek == null){
            beneficeWeek = 0.0;
        }
        statistics.add(beneficeWeek);

        Double beneficeWeekBefore = commandeRepo.beneficeWeekBefore();
        if(beneficeWeekBefore == null){
            beneficeWeekBefore = 0.0;
        }
        statistics.add(beneficeWeekBefore);

        Double caWeek = commandeRepo.chiffreAffaireLastWeek();
        if(caWeek == null){
            caWeek = 0.0;
        }

        statistics.add(caWeek);

        Double caWeekBefore = commandeRepo.chiffreAffaireWeekBefore();
        if(caWeekBefore == null){
            caWeekBefore = 0.0;
        }

        statistics.add(caWeekBefore);


        Double beneficeMonth = commandeRepo.beneficeLastMonth();
        if(beneficeMonth == null){
            beneficeMonth = 0.0;
        }

        statistics.add(beneficeMonth);

        Double beneficeMonthBefore = commandeRepo.beneficeMonthBefore();
        if(beneficeMonthBefore == null){
            beneficeMonthBefore = 0.0;
        }

        statistics.add(beneficeMonthBefore);

        Double caMonth = commandeRepo.chiffreAffaireLastMonth();
        if(caMonth == null){
            caMonth = 0.0;
        }

        statistics.add(caMonth);

        Double caMonthBefore = commandeRepo.chiffreAffaireMonthBefore();
        if(caMonthBefore == null){
            caMonthBefore = 0.0;
        }

        statistics.add(caMonthBefore);

        Double beneficeYear = commandeRepo.beneficeLastYear();
        if(beneficeYear == null){
            beneficeYear = 0.0;
        }

        statistics.add(beneficeYear);

        Double beneficeYearBefore = commandeRepo.beneficeYearBefore();
        if(beneficeYearBefore == null){
            beneficeYearBefore = 0.0;
        }

        statistics.add(beneficeYearBefore);

        Double caYear = commandeRepo.chiffreAffaireLastYear();
        if(caYear == null){
            caYear = 0.0;
        }

        statistics.add(caYear);

        Double caYearBefore = commandeRepo.chiffreAffaireYearBefore();
        if(caYearBefore == null){
            caYearBefore = 0.0;
        }

        statistics.add(caYearBefore);

        return statistics;
    }


}
