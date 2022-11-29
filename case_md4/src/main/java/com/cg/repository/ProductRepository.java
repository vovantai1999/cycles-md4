package com.cg.repository;

import com.cg.model.Product;
import com.cg.model.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT NEW com.cg.model.dto.ProductDTO (" +
            "p.id, " +
            "p.name, " +
            "p.image, " +
            "p.quantity,  " +
            "p.price, " +
            "p.category) " +
            "FROM Product AS p WHERE p.deleted = false")
    List<ProductDTO> findAllProductDTO();

    @Query("SELECT NEW com.cg.model.dto.ProductDTO (" +
            "p.id, " +
            "p.name, " +
            "p.image, " +
            "p.quantity, " +
            "p.price, " +
            "p.category) " +
            "FROM Product AS p WHERE p.id = :id")
    Optional<ProductDTO> findProductDTOById(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Product AS p SET p.deleted = true WHERE p.id = :id")
    void deleteProductById(@Param("id") Long id);

    @Query("SELECT NEW com.cg.model.dto.ProductDTO ( " +
            "p.id, " +
            "p.name, " +
            "p.image, " +
            "p.quantity, " +
            "p.price, " +
            "p.category) " +
            "FROM Product  p WHERE  " +
            " p.name like %?1% ")
    List<ProductDTO> findProductByValue(String query);

    @Query("SELECT NEW com.cg.model.Product (" +
            "p.id, " +
            "p.name, " +
            "p.image, " +
            "p.quantity,  " +
            "p.price, " +
            "p.category) " +
            "FROM Product AS p WHERE p.deleted = false AND p.category.id = :id")
    List<Product> findProductByCategoryIdAndDeletedIsFalse(@Param("id") Long id);
}
