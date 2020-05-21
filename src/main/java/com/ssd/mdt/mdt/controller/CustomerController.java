package com.ssd.mdt.mdt.controller;

import com.ssd.mdt.mdt.model.Customer;
import com.ssd.mdt.mdt.model.Tour;
import com.ssd.mdt.mdt.repository.CustomerRepository;
import com.ssd.mdt.mdt.repository.TourRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private final CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("list")
    public String customers(Model model){
        model.addAttribute("tours", this.customerRepository.findAll());
        return "customerList";
    }


    @GetMapping("/add-customer")
    public String showCustomerForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "addCustomer";
    }



    @PostMapping("/add")
    public String addCustomer(@Valid Customer customer, BindingResult results, Model model){
        if (results.hasErrors()){
            return "addCustomer";
        }
//        encrypt password
        String password = BCrypt.hashpw(customer.getPassword(), BCrypt.gensalt(12));
//      store encrypted password
        customer.setPassword(password);

        this.customerRepository.save(customer);

        return "redirect:list";
    }
}