package com.sardina.customer.service;

import com.sardina.customer.model.Customer;
import com.sardina.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer add(Customer customer) {
        return customerRepository.save(customer); }

    @Override
    @Transactional
    public void update(Customer customer) {
        customerRepository.save(customer); }

    @Override
    public Customer getById(int id) {
        return customerRepository.findOne(id); }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll(); }

    @Override
    @Transactional
    public void delete(int id) {
        customerRepository.delete(id); }


} //=== end CustomerServiceImpl implements CustomerService {}
