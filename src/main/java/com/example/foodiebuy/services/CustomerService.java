package com.example.foodiebuy.services;

import com.example.foodiebuy.models.Category;
import com.example.foodiebuy.models.Customer;
import com.example.foodiebuy.repositories.CategoryRepository;
import com.example.foodiebuy.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
            this.customerRepository = customerRepository;
        }
    public List<Customer> getCustomers() {
            return customerRepository.findAll();
    }

}
