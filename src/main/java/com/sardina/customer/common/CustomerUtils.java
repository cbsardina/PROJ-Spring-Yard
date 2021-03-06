package com.sardina.customer.common;

import com.sardina.customer.model.Customer;

import java.util.List;
import java.util.Random;

public class CustomerUtils {

    public static Customer createTestCustomer() {
        Random random = new Random();
        String firstName = "custFirst" + random.nextInt(10000);
        String lastName = "custLast" + random.nextInt(10000);
        String phone = "803" + "-" + random.nextInt(1000) + "-" + random.nextInt(10000);
        String email = random.nextInt(1000000) + "@custEmail.com";

        Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setPhone(phone);
            customer.setEmail(email);
        return customer;
    }

    public static Customer findInList(List<Customer> customers, String first, String last) {
        // Find the new person in the list
        for (Customer customer : customers) {
            if (customer.getFirstName().equals(first) && customer.getLastName().equals(last)) {
                return customer;
            }
        }
        return null;
    }


}
