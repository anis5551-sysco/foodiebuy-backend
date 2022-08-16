package com.example.foodiebuy.services;

import com.example.foodiebuy.models.Customer;
import com.example.foodiebuy.models.Product;
import com.example.foodiebuy.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
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
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional
public class CustomerServiceImpl implements CustomerService, UserDetailsService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

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
    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setCustomerPassword(passwordEncoder.encode(customer.getCustomerPassword()));
        Optional<Customer> customerOptional = customerRepository.findByCustomerEmailIs(customer.getCustomerEmail());
        if(customerOptional.isPresent()){
            throw new IllegalStateException("Customer with same name already exists");
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(String email) {
        return customerRepository.findByCustomerEmail(email);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }


}
