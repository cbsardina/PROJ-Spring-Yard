package com.sardina.customer.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sardina.customer.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.sardina.customer.common.CustomerUtils.createTestCustomer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void testAddGet() {
        Customer customer1 = createTestCustomer();
        Customer customer2 = createTestCustomer();
            customerService.add(customer1);
            customerService.add(customer2);

        Assert.assertNotNull(customer1);
        Assert.assertNotNull(customer2);

        customer1.setFirstName("Calvin");
        Assert.assertEquals(customer1.getFirstName(), "Calvin");
        Assert.assertFalse("Test that customer objects are not equal:", customer1.equals(customer2));
    }

    @Test
    public void testUpdate() {
        Customer customer1 = createTestCustomer();
        Customer customer2 = customer1;  //set customer 2 to original customer1
        Customer customer3 = createTestCustomer();
            customer1.setFirstName("Calvin");
            customer1.setLastName("Webster");
            customer1.setEmail("calvin@theironyard.com");
            customer1.setPhone("8033578392");
                customerService.add(customer1);
                customerService.add(customer2);
                customerService.add(customer3);

        Assert.assertEquals("Calvin", "Calvin");
        Assert.assertEquals("calvin@theironyard.com", "calvin@theironyard.com");

        Assert.assertTrue("Verify customer1 firstName was updated:", customer1.getFirstName().contentEquals(customer2.getFirstName()));
        Assert.assertTrue("Verify customer1 lastName was updated:", customer1.getLastName().contentEquals(customer2.getLastName()));
        Assert.assertTrue("Verify customer1 emailName was updated:", customer1.getEmail().contentEquals(customer2.getEmail()));
        Assert.assertTrue("Verify customer1 phoneName was updated:", customer1.getPhone().contentEquals(customer2.getPhone()));

        Assert.assertFalse("Verify customer1 firstName was updated:", customer1.getFirstName().contentEquals(customer3.getFirstName()));
        Assert.assertFalse("Verify customer1 lastName was updated:", customer1.getLastName().contentEquals(customer3.getLastName()));
        Assert.assertFalse("Verify customer1 emailName was updated:", customer1.getEmail().contentEquals(customer3.getEmail()));
        Assert.assertFalse("Verify customer1 phoneName was updated:", customer1.getPhone().contentEquals(customer3.getPhone()));
    }

    //TODO: THIS TEST MAY HAVE TO BE UPDATED
    @Test
    public void testDelete() {
        Customer customer1 = createTestCustomer();
            customerService.add(customer1);

        Assert.assertNotNull("Verify customer1 exists:", customer1);

        customerService.delete(customer1.getId());

        Assert.assertEquals(0 ,customer1.getId());

    }

}
