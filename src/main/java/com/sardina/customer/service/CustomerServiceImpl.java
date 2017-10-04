package com.sardina.customer.service;

import com.sardina.customer.model.Customer;
import com.sardina.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    @Override
    public void add(Customer customer) {
        customerRepository.add(customer); }

    @Transactional
    @Override
    public void update(Customer customer) {
        customerRepository.update(customer); }

    @Override
    public Customer getById(int id) {
        return customerRepository.getById(id); }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll(); }

    @Transactional
    @Override
    public void delete(int id) {
        customerRepository.delete(id); }

} //=== end CustomerServiceImpl implements CustomerService {}
