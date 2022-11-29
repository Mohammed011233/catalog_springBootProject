package com.catalog.repositries;

import com.catalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Product , Long> {

    List<Product> findBycategoryId(Long id);

//    @Transactional
//    @Modifying
//    @Query("UPDATE Product SET quantity = :quantity " +
//            ", popurity = :popurity" +
//            ", lastQuantityOrdered = :lastQuantityOrdered" +
//            " WHERE id = :id")
//    void updateQuantity(Integer quantity , Integer popurity , Integer lastQuantityOrdered, Long id);


    List<Product> findByOrderByPopurityDesc();
}
