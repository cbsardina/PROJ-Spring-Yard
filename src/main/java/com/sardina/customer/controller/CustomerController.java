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

/** * * * * * * * *
     Login, Logout, & Admin Route
 */
    @GetMapping("/login")
    String login() {
    return "login";
}

    @GetMapping("/loggedout")
    public String logout() {
        return "redirect:/home";
    }

    @GetMapping("/admins-only")
    String admins() {
        return "administration";
    }

/** * * * * * * * *
     /home & '/' redirect:/home
 */
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/")
    public String redirHome() {
        return "redirect:/home";
    }

/** * * * * * * * *
     Get All Customers & Get 1
 */
    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAll();
        customers.stream()
                .forEach(customer -> System.out.println(customer));
            model.addAttribute("customers", customers);

        return "customerPage";
    }

    @GetMapping("/customers/{id}")
    public String get1Customer(@PathVariable("id") int id, Model model) {
        Customer customer = customerService.getById(id);
            model.addAttribute("customer", customer);

        return "viewCustomer";
    }

/** * * * * * * * *
     Get AddCust Form + Post Add Customer
 */
    @GetMapping("/customers/add_new")
    public String addCustomerForm() {
        return "addCustomer";
    }

    @PostMapping("/customers")
    public String addCustomer(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName, @RequestParam(value = "phone") String phone, @RequestParam(value = "email") String email) {
        Customer customer = new Customer();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setPhone(phone);
            customer.setEmail(email);
                customerService.add(customer);

        return "redirect:/customers";
    }

/** * * * * * * * *
     Exception handler
 */
    @ExceptionHandler(value = Exception.class)
    public String handleDefaultErrors(final Exception exception, Model model) {
        System.out.println(exception);
        model.addAttribute("message", exception.getMessage());
        return "error_message";
    }

}
