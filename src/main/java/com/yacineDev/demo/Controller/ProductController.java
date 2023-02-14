package com.yacineDev.demo.Controller;

import com.yacineDev.demo.Services.ProductService;
import com.yacineDev.demo.module.Employee;
import com.yacineDev.demo.module.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/all/nameAsc")
    public ResponseEntity<List<Product>> getAllProductsOrderedByName(){
        List<Product> products = productService.findAllProductsOrderedByName();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/all/nameDesc")
    public ResponseEntity<List<Product>> getAllProductsOrderedByNameDESC(){
        List<Product> products = productService.findAllProductsOrderedByNameDESC();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/all/categoryAsc")
    public ResponseEntity<List<Product>> getAllProductsOrderedByCategory(){
        List<Product> products = productService.findAllProductsOrderedByCategory();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/all/categoryDesc")
    public ResponseEntity<List<Product>> getAllProductsOrderedByCategoryDESC(){
        List<Product> products = productService.findAllProductsOrderedByCategoryDESC();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/all/priceAsc")
    public ResponseEntity<List<Product>> getAllProductsOrderedByPrice(){
        List<Product> products = productService.findAllByOrderByPrice();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/all/priceDesc")
    public ResponseEntity<List<Product>> getAllProductsOrderedByPriceDESC(){
        List<Product> products = productService.findAllByOrderByPriceDesc();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/all/quantityAsc")
    public ResponseEntity<List<Product>> getAllProductsOrderedByQuantity(){
        List<Product> products = productService.findAllByOrderByQuantity();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/all/quantityDesc")
    public ResponseEntity<List<Product>> getAllProductsOrderedByQuantityDESC(){
        List<Product> products = productService.findAllByOrderByQuantityDesc();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


}
