package com.example.foodiebuy.repositories;

import com.example.foodiebuy.models.Category;
import com.example.foodiebuy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findByProductName(String productName);
}
