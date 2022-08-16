package com.example.foodiebuy.repositories;

import com.example.foodiebuy.models.Customer;
import com.example.foodiebuy.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByCustomerEmail(String email);
    Optional<Customer> findByCustomerEmailIs(String email);

}
