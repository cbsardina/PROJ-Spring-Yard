package com.sardina.customer.controller;

import com.sardina.customer.model.Customer;
import com.sardina.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(path = "/home/customers", method = RequestMethod.GET)
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAll();
            model.addAttribute("customers", customers);

        return "customerPage";
    }

    @RequestMapping(path = "/home/customers/customer_{id}", method = RequestMethod.GET)
    public String get1Customer(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.getById(id);
            model.addAttribute("customer", customer);

        return "viewCustomer";
    }

    @RequestMapping(path = "/home/customers/add_new", method = RequestMethod.POST)
    public String addCustomer(@RequestBody String firstName, @RequestBody String lastName, @RequestBody String phone,
                              @RequestBody String email) {
        Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setPhone(phone);
            customer.setEmail(email);
                customerService.add(customer);
        //TODO: may have to make this a redirect??
        return "customerPage";
    }


}
