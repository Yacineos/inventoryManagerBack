package com.yacineDev.demo.Services;

import com.yacineDev.demo.Repositories.FournitRepo;
import com.yacineDev.demo.Repositories.ProductRepo;
import com.yacineDev.demo.module.Fournit;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    public void addFournit(Long idF,int idP , int quantite ){
        fournitRepo.addFournit(idF,idP,quantite, LocalDate.now());
        productRepo.addQuantity(quantite,idP);
    }
    @Transactional
    public List<Fournit> getAllFournit(){
        return fournitRepo.findAllFournit();
    }

}
