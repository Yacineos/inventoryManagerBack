package com.yacineDev.demo.Controller;

import com.yacineDev.demo.Services.FournitService;
import com.yacineDev.demo.module.Fournit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/fournit")
public class FournitController {
    private final FournitService fournitService;

    public FournitController(FournitService fournitService) {
        this.fournitService = fournitService;
    }
    @GetMapping("/all")
    public List<Fournit> getAllFournit(){
        return fournitService.getAllFournit();
    }
    @PostMapping("/add")
    public ResponseEntity<Fournit> addFournit(@RequestBody Fournit fournit){
        System.out.println(fournit.getQte_produit());
        System.out.println(fournit.getIdF());
        System.out.println(fournit.getIdProduit());
        fournitService.addFournit(fournit.getIdF(),fournit.getIdProduit(),fournit.getQte_produit());
        return new ResponseEntity<>(fournit, HttpStatus.OK);
    }
    @PostMapping("/addH")
    public ResponseEntity<Fournit> addFournitHatba(@RequestBody Fournit fournit){
        fournitService.addFournitHatba(fournit.getIdF(),fournit.getIdProduit(),fournit.getQte_produit());
        return new ResponseEntity<>(fournit, HttpStatus.OK);
    }
}
