package com.example.foodiebuy.repositories;

import com.example.foodiebuy.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
