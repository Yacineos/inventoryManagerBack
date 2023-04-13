package com.yacineDev.demo.Controller;

import com.yacineDev.demo.Services.CommandeService;
import com.yacineDev.demo.module.Commande;
import com.yacineDev.demo.module.CommandeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Commande>> getAllCommandes(){
        List<Commande> commandes = commandeService.findAllCommandes();
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    @GetMapping("/lastId")
    public ResponseEntity<Integer> getLastId(){
        int lastId = commandeService.findLastId();
        return new ResponseEntity<>(lastId, HttpStatus.OK);
    }

    @GetMapping("/findIdClient/{id}")
    public ResponseEntity<Integer> findIdClientByIdCommande(@PathVariable("id") Long id){
        int idClient = commandeService.findIdClientByIdCommande(id);
        return new ResponseEntity<>(idClient, HttpStatus.OK);
    }
    @GetMapping("/getCommandeInfo/{id}")
    public ResponseEntity<List<?>> getCommandeInformation(@PathVariable("id") Long id) throws SQLException {
        List<?> commandeInfos = commandeService.getCommandeInformation(id);
        return new ResponseEntity<>(commandeInfos, HttpStatus.OK);
    }

    @GetMapping("/statistics")
    public ResponseEntity<List<Double>> getStatistics() throws SQLException {
        List<Double> statistics = commandeService.statistics();
        return new ResponseEntity<>(statistics, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Commande> addCommande(@RequestBody Commande commande){
        Commande newCommande = null ;
        commandeService.addCommande(commande);
        return new ResponseEntity<>(newCommande, HttpStatus.CREATED);
    }

    @PutMapping("/modify")
    public ResponseEntity<Commande> modifyCommande(@RequestBody Commande commande){
        Commande newCommande = null ;
        commandeService.modifyCommande(commande);
        return new ResponseEntity<>(newCommande, HttpStatus.CREATED);
    }






}

