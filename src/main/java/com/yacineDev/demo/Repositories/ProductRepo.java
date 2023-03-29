package com.yacineDev.demo.Repositories;
import com.yacineDev.demo.module.Employee;
import com.yacineDev.demo.module.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query(value="DELETE FROM produit WHERE id_produit = ?1",nativeQuery = true)
    void deleteProductById(int id);
    @Query(value="SELECT * FROM produit",nativeQuery = true)
    List<Product> findAllProducts();
    @Query(value="SELECT * FROM produit ORDER BY nom",nativeQuery = true)
    List<Product> findAllByOrderByNom();
    @Query(value="SELECT * FROM produit ORDER BY nom DESC",nativeQuery = true)
    List<Product> findAllByOrderByNomDesc();
    @Query(value="SELECT * FROM produit ORDER BY category",nativeQuery = true)
    List<Product> findAllByOrderCategory();
    @Query(value="SELECT * FROM produit ORDER BY category DESC",nativeQuery = true)
    List<Product> findAllByOrderCategoryDesc();
    @Query(value="SELECT * FROM produit ORDER BY prix_unitaire",nativeQuery = true)
    List<Product> findAllByOrderByPrice();
    @Query(value="SELECT * FROM produit ORDER BY prix_unitaire DESC",nativeQuery = true)
    List<Product> findAllByOrderByPriceDesc();
    @Query(value="SELECT * FROM produit ORDER BY produit_en_stock",nativeQuery = true)
    List<Product> findAllByOrderByQuantity();
    @Query(value="SELECT * FROM produit ORDER BY produit_en_stock DESC",nativeQuery = true)
    List<Product> findAllByOrderByQuantityDesc();
    @Query(value="SELECT * FROM produit WHERE nom LIKE %?1% OR category LIKE %?1% ",nativeQuery = true)
    List<Product> findProductsByInput(String input);
    @Query(value="SELECT * FROM produit WHERE id_produit = ?1",nativeQuery = true)
    Optional<Product> findProductById(int id);

    @Modifying
    @Transactional
    @Query(value="UPDATE produit SET produit_en_stock = produit_en_stock + ?1 WHERE id_produit = ?2",nativeQuery = true)
    void addQuantity(int quantity,int id);


}
