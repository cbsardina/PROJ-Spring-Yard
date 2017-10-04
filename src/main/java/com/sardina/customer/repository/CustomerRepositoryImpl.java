package com.sardina.customer.repository;

import com.sardina.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

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
