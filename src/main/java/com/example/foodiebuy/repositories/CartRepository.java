package com.example.foodiebuy.repositories;

import com.example.foodiebuy.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
