package com.sardina.customer.controller;


import com.sardina.customer.model.Customer;
import com.sardina.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    public String getCustomers() {
        List<Customer> customers = customerService.getAll();
            //TODO: templating to render all customers to page.
        return "customerPage";
    }




}
