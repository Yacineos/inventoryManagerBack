package com.yacineDev.demo.Controller;

import com.yacineDev.demo.Services.CommandeService;
import com.yacineDev.demo.module.Commande;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseEntity<Commande> addCommande(@RequestBody Commande commande){
        Commande newCommande = null ;
        commandeService.addCommande(commande);
        return new ResponseEntity<>(newCommande, HttpStatus.CREATED);
    }

}

