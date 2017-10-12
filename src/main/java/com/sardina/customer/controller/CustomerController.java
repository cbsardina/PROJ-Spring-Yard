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

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String redirHome() {
        return "redirect:/home";
    }

    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAll();
        customers.stream()
                .forEach(customer -> System.out.println(customer));
            model.addAttribute("customers", customers);

        return "customerPage";
    }

    @RequestMapping(path = "/customers/{id}", method = RequestMethod.GET)
    public String get1Customer(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.getById(id);
            model.addAttribute("customer", customer);

        return "viewCustomer";
    }

    @RequestMapping(path = "/customers/add_new", method = RequestMethod.GET)
    public String addCustomerForm() {
        return "addCustomer";
    }

    @RequestMapping(path = "/customers", method = RequestMethod.POST)
    public String addCustomer(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "phone") String phone, @RequestParam(value = "email") String email) {
        Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setPhone(phone);
            customer.setEmail(email);
                customerService.add(customer);

        return "redirect:/customers";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleDefaultErrors(final Exception exception, Model model) {
        System.out.println(exception);
        model.addAttribute("message", exception.getMessage());
        return "error_message";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @RequestMapping(path = "/loggedout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:/home";
    }

    @GetMapping("/admins-only")
    String admins() {
        return "administration";
    }


}
