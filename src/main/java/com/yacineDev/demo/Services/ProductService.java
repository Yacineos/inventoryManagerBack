package com.yacineDev.demo.Services;

import com.yacineDev.demo.Repositories.EmployeeRepo;
import com.yacineDev.demo.Repositories.ProductRepo;
import com.yacineDev.demo.exception.ProductNotFoundException;
import com.yacineDev.demo.exception.UserNotFoundException;
import com.yacineDev.demo.module.Product;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepo ;

    @Autowired
    public ProductService(ProductRepo productRepo,
                          EmployeeRepo employeeRepo) {
        this.productRepo = productRepo;
    }
    @Transactional
    public Product addProduct(Product product){
        Optional<Product> product1 = productRepo.findProductById(product.getId());
        if(!product1.isPresent()) {
            productRepo.addProduct(product.getId(), product.getName(), product.getCategory(), product.getPrice(),product.getPrix_de_revient());
        }
        return null;
    }
    @Transactional
    public List<Product> findAllProducts(){
        return productRepo.findAllProducts();
    }
    @Transactional
    public List<Product> findAllProductsOrderedByName(){
        return productRepo.findAllByOrderByNom();
    }
    @Transactional
    public List<Product> findAllProductsOrderedByNameDESC(){
        return productRepo.findAllByOrderByNomDesc();
    }
    @Transactional
    public List<Product> findAllProductsOrderedByCategory(){
        return productRepo.findAllByOrderCategory();
    }
    @Transactional
    public List<Product> findAllProductsOrderedByCategoryDESC(){
        return productRepo.findAllByOrderCategoryDesc();
    }
    @Transactional
    public List<Product> findProductsByInput(String input){
        return productRepo.findProductsByInput(input);
    }
    @Transactional
    public List<Product> findAllByOrderByPrice(){
        return productRepo.findAllByOrderByPrice();
    }
    @Transactional
    public List<Product> findAllByOrderByPriceDesc(){
        return productRepo.findAllByOrderByPriceDesc();
    }
    @Transactional
    public List<Product> findAllByOrderByQuantity(){
        return productRepo.findAllByOrderByQuantity();
    }
    @Transactional
    public List<Product> findAllByOrderByQuantityDesc(){
        return productRepo.findAllByOrderByQuantityDesc();
    }


    @Transactional
    public Product updateProduct(Product product){
        System.out.println("Product : "+product.getId());
        return productRepo.save(product);
    }
    @Transactional
    public Product findProductById(Long id){
        return productRepo.findProductById(id).orElseThrow(() -> new ProductNotFoundException("Product By id : "+id+" was not found "));
    }
    public List<Product> findListProductsById(Long id){
        return productRepo.findListProductsById(id);
    }

    public void deleteProduct(Long id){
        productRepo.deleteProductById(id);
    }

    @Transactional
    public void addQuantity(int quantity, Long id){
        productRepo.addQuantity(quantity, id);
    }

    @Transactional
    public void subtractQuantity(int quantity, Long id){
        productRepo.subtractQuantity(quantity, id);
    }
}
