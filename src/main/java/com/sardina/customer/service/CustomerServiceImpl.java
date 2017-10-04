package com.sardina.customer.service;

import com.sardina.customer.model.Customer;
import com.sardina.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void add(Customer customer) {
        //TODO: add(Customer c)
    }

    @Override
    public void update(Customer customer) {
        //TODO: update(Customer c)
    }

    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public void delete(int id) {
        //TODO: delete(int i)
    }
}
