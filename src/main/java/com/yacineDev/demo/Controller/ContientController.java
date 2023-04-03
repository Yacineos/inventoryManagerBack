package com.yacineDev.demo.Controller;

import com.yacineDev.demo.Repositories.ContientRepo;
import com.yacineDev.demo.Services.ContientService;
import com.yacineDev.demo.module.Contient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contient")
public class ContientController {

    private final ContientService contientService;
    private final ContientRepo contientRepo;

    public ContientController(ContientService contientService,
                              ContientRepo contientRepo) {
        this.contientService = contientService;
        this.contientRepo = contientRepo;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contient>> getAllContient(){
        List<Contient> contients = contientService.findAllContient();
        return new  ResponseEntity<>(contients, HttpStatus.OK);
    }

    @GetMapping("/allTest")
    public ResponseEntity<List<Integer>> testGetAllContient(){
        List<Integer> contients = contientRepo.testGetAllContient();
        return new  ResponseEntity<>(contients, HttpStatus.OK);
    }

    @GetMapping("/findContientByIdCommande/{id}")
    public ResponseEntity<List<Contient>> findContientByIdCommande(@PathVariable("id") Long id){
        List<Contient> contients = contientService.findContientByIdCommande(id);
        return new ResponseEntity<>(contients,HttpStatus.OK);
    }

    @PostMapping("/addContient/{id_commande}/{id_produit}/{quantite}")
    public void addContient(@PathVariable("id_commande") Long id_commande ,@PathVariable("id_produit") Long id_produit ,@PathVariable("quantite") int quantite){
        contientService.addContient(id_commande , id_produit , quantite);
    }

    @DeleteMapping("/deleteContientByIdCommande/{id}")
    public void deleteContientByIdCommande(@PathVariable("id") Long id){
        contientService.deleteContientByIdCommande(id);
    }

    @PostMapping("/updateContient/{quantite}/{id_commande}/{id_produit}")
    public void updateContient(@PathVariable("quantite") int quantite,@PathVariable("id_commande") Long id_commande,@PathVariable("id_produit") Long id_produit){
        contientService.updateContient(quantite,id_commande,id_produit);
    }

}
