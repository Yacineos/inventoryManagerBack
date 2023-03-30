package com.yacineDev.demo.Services;

import com.yacineDev.demo.Repositories.FournitRepo;
import com.yacineDev.demo.Repositories.ProductRepo;
import com.yacineDev.demo.module.Fournit;
import com.yacineDev.demo.module.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FournitService {
    private final FournitRepo fournitRepo;
    private final ProductRepo productRepo;

    @Autowired
    public FournitService(FournitRepo fournitRepo,
                          ProductRepo productRepo) {
        this.fournitRepo = fournitRepo;
        this.productRepo = productRepo;
    }
    @Transactional
    public void addFournit(Long idF,Long idP , int quantite ){
            System.out.println(idF+" "+idP+" "+quantite);
            fournitRepo.addFournit(idF, idP, quantite, LocalDate.now());
            System.out.println("Fournit added");
            productRepo.addQuantity(quantite, idP);
            System.out.println("Quantity added");
    }
    @Transactional
    public List<Fournit> getAllFournit(){
        return fournitRepo.findAllFournit();
    }

    @Transactional
    public void addFournitHatba(Long idF,Long idP , int quantite ){
        fournitRepo.addFournit(idF, idP, quantite, LocalDate.now());
    }

}
