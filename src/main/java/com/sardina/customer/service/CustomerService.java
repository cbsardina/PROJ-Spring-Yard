package com.sardina.customer.service;

import com.sardina.customer.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer add(Customer customer);
    void update(Customer customer);
    Customer getById(int id);
    List<Customer> getAll();
    void delete(int id);

}
