package com.yacineDev.demo.Controller;

import com.yacineDev.demo.Services.CostumerService;
import com.yacineDev.demo.Services.EmployeeService;
import com.yacineDev.demo.module.Costumer;
import com.yacineDev.demo.module.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costumer")
public class CostumerController {
    private final CostumerService costumerService;

    public CostumerController(CostumerService costumerService) {
        this.costumerService = costumerService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Costumer>> getAllCostumers(){
        List<Costumer> costumers = costumerService.findAllCostumers();
        return new ResponseEntity<>(costumers, HttpStatus.OK);
    }
    @GetMapping("/all/nameAsc")
    public ResponseEntity<List<Costumer>> getAllCostumersOrderedByName(){
        List<Costumer> costumers = costumerService.findAllCostumersOrderedByName();
        return new ResponseEntity<>(costumers,HttpStatus.OK);
    }
    @GetMapping("/all/nameDesc")
    public ResponseEntity<List<Costumer>> getAllCostumersOrderedByNameDESC(){
        List<Costumer> costumers = costumerService.findAllCostumersOrderedByNameDESC();
        return new ResponseEntity<>(costumers,HttpStatus.OK);
    }
    @GetMapping("/all/emailAsc")
    public ResponseEntity<List<Costumer>> getAllCostumersOrderedByEmail(){
        List<Costumer> costumers = costumerService.findAllCostumersOrderedByEmail();
        return new ResponseEntity<>(costumers,HttpStatus.OK);
    }
    @GetMapping("/all/emailDesc")
    public ResponseEntity<List<Costumer>> getAllCostumersOrderedByEmailDESC(){
        List<Costumer> costumers = costumerService.findAllCostumersOrderedByEmailDESC();
        return new ResponseEntity<>(costumers,HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Costumer> getCostumerById(@PathVariable("id") Long id) {
        Costumer costumer = costumerService.findCostumerById(id);
        return new ResponseEntity<>(costumer, HttpStatus.OK);
    }
    @GetMapping("/findCostumers/{input}")
    public ResponseEntity<List<Costumer>> getCostumerByInput(@PathVariable("input") String input) {
        List<Costumer> costumers = costumerService.findCostumersByInput(input);
        return new ResponseEntity<>(costumers, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Costumer> addCostumer(@RequestBody Costumer costumer){
        Costumer newCostumer = costumerService.addCostumer(costumer);
        return new ResponseEntity<>(newCostumer,HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Costumer> updateEmployee(@RequestBody Costumer costumer){
        Costumer updateCostumer = costumerService.updateCostumer(costumer);
        return new ResponseEntity<>(updateCostumer,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCostumer(@PathVariable("id") Long id){
        costumerService.deleteCostumer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
