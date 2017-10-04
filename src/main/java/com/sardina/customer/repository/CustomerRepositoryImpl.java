package com.sardina.customer.repository;

import com.sardina.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String ADD_CUST = "INSERT INTO customer (firstName, lastName, phone, email) VALUES (?,?,?,?)";
    @Override
    public void add(Customer customer) {
        jdbcTemplate.update(ADD_CUST, customer.getFirstName(), customer.getLastName(), customer.getPhone(), customer.getEmail());
    }

    private final String UPDATE_CUST = "UPDATE customer SET firstName=?, lastName=?, phone=?, email=? WHERE id=?";
    @Override
    public void update(Customer customer) {
        jdbcTemplate.update(UPDATE_CUST, customer.getFirstName(), customer.getLastName(), customer.getPhone(), customer.getEmail(), customer.getId());
    }

    private final String GET_BY_ID_CUST = "SELECT * FROM customer WHERE id=?";
    @Override
    public Customer getById(int id) {

        return jdbcTemplate.queryForObject(GET_BY_ID_CUST, new CustomerMapper(), id);
    }

    private final String GET_ALL_CUST = "SELECT * FROM customer";
    @Override
    public List<Customer> getAll() {
        return jdbcTemplate.query(GET_ALL_CUST, new CustomerMapper());
    }

    private final String DELETE_ONE_CUST = "DELETE FROM customer WHERE id=?";
    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_ONE_CUST, id);
    }

  // +++ create mapper for customer object creation ++
    public class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Customer customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setFirstName(resultSet.getString("firstName"));
                customer.setLastName(resultSet.getString("lastName"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setEmail(resultSet.getString("email"));

            return customer;
        }
    }
}
