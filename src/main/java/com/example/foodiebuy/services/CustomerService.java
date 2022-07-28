package com.example.foodiebuy.services;

import com.example.foodiebuy.models.Customer;
import com.example.foodiebuy.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @Transactional @RequiredArgsConstructor
public class CustomerService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByCustomerEmail(email);
        if (customer == null){
            throw new UsernameNotFoundException("User Not found");
        }

        Collection<SimpleGrantedAuthority> authority = new ArrayList<>();
        authority.add(new SimpleGrantedAuthority(customer.getRole().toString()));

        return new User(customer.getCustomerEmail(), customer.getCustomerPassword(), authority);
    }

    @Autowired
    public List<Customer> getCustomers() {
            return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer){

        customer.setCustomerPassword(passwordEncoder.encode(customer.getCustomerPassword()));

        return customerRepository.save(customer);

    }



}
