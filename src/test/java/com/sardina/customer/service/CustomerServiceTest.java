package com.sardina.customer.service;

import com.sardina.customer.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.sardina.customer.common.CustomerUtils.createTestCustomer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void testAddGet() {
        Customer customer1 = createTestCustomer();
        //TODO: testAddGet()
    }

    @Test
    public void testUpdate() {
        //TODO: testUpdate()
    }

    @Test
    public void testDelete() {
        //TODO: testDelete()
    }

}
