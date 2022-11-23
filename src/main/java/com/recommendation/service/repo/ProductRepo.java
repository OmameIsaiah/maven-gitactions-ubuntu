package com.recommendation.service.repo;

import com.recommendation.service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("select pro from Product pro where pro.name=?1")
    Optional<Product> getProductByName(String name);
}
