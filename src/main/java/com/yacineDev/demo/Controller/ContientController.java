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

    @GetMapping("findNbElementByIdCommande/{id}")
    public ResponseEntity<Integer> findNbElementByIdCommande(@PathVariable("id") Long id){
        int nbElement = contientService.findNbElementByIdCommande(id);
        return new ResponseEntity<>(nbElement,HttpStatus.OK);
    }

    @PostMapping("/addContient")
    public void addContient(@RequestBody Contient contient){
        contientService.addContient(contient.getId().getIdCommande(), contient.getId().getIdProduit(), contient.getQte_produit());
    }

    @DeleteMapping("/deleteContientByIdCommande/{id}")
    public void deleteContientByIdCommande(@PathVariable("id") Long id){
        contientService.deleteContientByIdCommande(id);
    }


    @PostMapping("/update")
    public void updateContient(@RequestBody Contient contient){
        contientService.updateContient(contient.getQte_produit(),contient.getId().getIdCommande(), contient.getId().getIdProduit());
    }

}
