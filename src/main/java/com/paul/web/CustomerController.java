package com.paul.web;

import com.paul.domain.Customer;
import com.paul.domain.User;
import com.paul.service.def.CustomerService;
import com.paul.service.def.UserHelper;
import com.paul.web.exception.ItemNotFoundException;
import com.paul.web.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by paulzhang on 15/12/2016.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private UserHelper userHelper;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String showAllCustomers(@PageableDefault(size = 15, sort = {"createDate"}, direction = Sort.Direction.DESC) Pageable pageable, Model model) throws ItemNotFoundException {
        User user = userHelper.getUserFromAuthentication();
        Page<Customer> customerList = customerService.findByUser(user, pageable);
        model.addAttribute("customerList", customerList);

        return "customerList";
    }

    @GetMapping(value = "/{customerId}")
    public String showOneCustomer(@PathVariable Long customerId, Model model) throws ItemNotFoundException, UnauthorizedException {
        Customer customer = customerService.findById(customerId);
        User user = userHelper.getUserFromAuthentication();
        if (null == customer) throw new ItemNotFoundException("Customer with ID: " + customerId + " does not exist.");
        else model.addAttribute("customer", customer);
        if (user.getId() != customer.getUser().getId()) throw new UnauthorizedException("Authentication needed");
        return "customerDetail";
    }

    @GetMapping(value = "/{customerId}/modify")
    public String modifyOneCustomer(@PathVariable Long customerId, Model model) throws ItemNotFoundException, UnauthorizedException {
        Customer customer = customerService.findById(customerId);
        User user = userHelper.getUserFromAuthentication();
        if (null == customer) throw new ItemNotFoundException("Customer with ID: " + customerId + " does not exist.");
        else model.addAttribute("customer", customer);
        if (user.getId() != customer.getUser().getId()) throw new UnauthorizedException("Authentication needed");
        return "customerCreateModify";
    }

    @PostMapping(value = "/{customerId}/modify")
    public String modifyOneCustomerOnSubmit(@PathVariable Long customerId, @ModelAttribute @Valid Customer customer, BindingResult bindingResult) throws ItemNotFoundException, UnauthorizedException {
        if (bindingResult.hasErrors()) return "customerCreateModify";
        User user = userHelper.getUserFromAuthentication();
        Customer originalCustomer = customerService.findById(customerId);

        if (null == originalCustomer) throw new ItemNotFoundException("Customer with ID: " + customerId + " does not exist.");
        if (originalCustomer.getUser().getId() != user.getId()) throw new UnauthorizedException("Authentication needed");

        originalCustomer.setFirstName(customer.getFirstName());
        originalCustomer.setLastName(customer.getLastName());
        originalCustomer.setCountry(customer.getCountry());
        originalCustomer.setActive(customer.isActive());
        originalCustomer.setCountry(customer.getCountry());
        originalCustomer.setProvince(customer.getProvince());
        originalCustomer.setCity(customer.getCity());
        originalCustomer.setAddress(customer.getAddress());
        originalCustomer.setZipCode(customer.getZipCode());
        originalCustomer.setPhoneNumber(customer.getPhoneNumber());
        originalCustomer.setIdNumber(customer.getIdNumber());
        originalCustomer.setComment(customer.getComment());

        return "redirect:/customer/" + customerId;
    }
}
