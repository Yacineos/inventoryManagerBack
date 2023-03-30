package com.yacineDev.demo.Controller;

import com.yacineDev.demo.Services.ProductService;
import com.yacineDev.demo.module.Employee;
import com.yacineDev.demo.module.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/find/{input}")
    public ResponseEntity<List<Product>> findProductsByInput(@PathVariable("input") String input){
        List<Product> products = productService.findProductsByInput(input);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<List<Product>> addProduct(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<List<Product>> updateProduct(@RequestBody Product product){
        System.out.println("update product"+ product.getId() +" "+ product.getName());
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addQte/{id}/{qte}")
    public ResponseEntity<List<Product>> addQte(@PathVariable("id") Long id,@PathVariable("qte") int qte){
        productService.addQuantity(qte,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
