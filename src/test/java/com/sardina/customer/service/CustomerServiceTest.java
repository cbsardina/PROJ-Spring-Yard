package com.sardina.customer.service;

import com.sardina.customer.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.sardina.customer.common.CustomerUtils.createTestCustomer;
import static com.sardina.customer.common.CustomerUtils.findInList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void testAddGet() {
        String firstName = "Joey";
        String lastName = "BaggaDoughnuts";

        Customer customer1 = new Customer();
        customer1.setFirstName(firstName);
        customer1.setLastName(lastName);
            customerService.add(customer1);

        List<Customer> customers = customerService.getAll();
            System.out.println(customers);
        Customer customer2 = findInList(customers, firstName, lastName);
        Assert.assertNotNull(customer2);

        Customer customer3 = customerService.getById(customer2.getId());
        Assert.assertNotNull(customer3);
        Assert.assertEquals(firstName, customer3.getFirstName());
        Assert.assertEquals(lastName, customer3.getLastName());

        customerService.delete(customer3.getId());
        customerService.delete(customer2.getId());
        customerService.delete(customer1.getId());
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

        customerService.delete(customer1.getId());
        customerService.delete(customer2.getId());
        customerService.delete(customer3.getId());
    }

    @Test
    public void testDelete() {
        int initialDBSize = customerService.getAll().size();

        Customer customer1 = createTestCustomer();
            String cust1LastName = customer1.getLastName();
            String cust1FirstName = customer1.getFirstName();
        Customer customer2 = createTestCustomer();
            String cust2LastName = customer2.getLastName();
            String cust2FirstName = customer2.getFirstName();
        customerService.add(customer1);
        customerService.add(customer2);

        List<Customer> customers = new ArrayList<>();

        customers.addAll(customerService.getAll());
        Assert.assertNotNull("Verify customers is now not null:", customers);

        int afterAdd2DbSize = customerService.getAll().size();

        Assert.assertTrue("Verify that original DB size does not equal current after adding 2: ", initialDBSize != afterAdd2DbSize);
        int result = afterAdd2DbSize - initialDBSize;
        Assert.assertTrue("Verify DB increased by 2: ", result == 2);

        Customer del1 = findInList(customers, cust1FirstName, cust1LastName);
            int c1Delete = del1.getId();
        Customer del2 = findInList(customers, cust2FirstName, cust2LastName);
            int c2Delete = del2.getId();

        customerService.delete(c1Delete);
        customerService.delete(c2Delete);

        int afterDeleteDBsize = customerService.getAll().size();

        Assert.assertTrue("Verify final DB size equals original DB size", afterDeleteDBsize == initialDBSize);

    }

}
