package com.example.foodiebuy.controllers;


import com.example.foodiebuy.models.Customer;
import com.example.foodiebuy.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok().body(customerService.getCustomers());
    }

    @PostMapping(path = "/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return ResponseEntity.created(null).body(customerService.saveCustomer(customer));
    }
}
