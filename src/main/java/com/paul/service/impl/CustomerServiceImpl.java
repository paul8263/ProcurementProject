package com.paul.service.impl;

import com.paul.domain.Customer;
import com.paul.domain.User;
import com.paul.service.def.CustomerService;
import com.paul.service.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 *
 * Implementation of CustomerService
 */
@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Transactional
    @Override
    public void saveCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    @Transactional
    @Override
    public void setCustomerActive(Customer customer, boolean isActive) {
        customer.setActive(isActive);
        customerRepo.save(customer);
    }

    @Transactional
    @Override
    public void deleteCustomer(Customer customer) {
        customerRepo.delete(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public List<Customer> findAll(boolean isActive) {
        return customerRepo.findByIsActive(isActive);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepo.findAll(pageable);
    }

    @Override
    public Page<Customer> findAll(boolean isActive, Pageable pageable) {
        return customerRepo.findByIsActive(isActive, pageable);
    }

    @Override
    public List<Customer> findByFullName(String firstName, String lastName) {
        return customerRepo.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Customer> findByUser(User user) {
        return customerRepo.findByUser(user);
    }

    @Override
    public List<Customer> findByUser(boolean isActive, User user) {
        return customerRepo.findByUserAndIsActive(user, isActive);
    }

    @Override
    public Page<Customer> findByUser(User user, Pageable pageable) {
        return customerRepo.findByUser(user, pageable);
    }

    @Override
    public Page<Customer> findByUser(boolean isActive, User user, Pageable pageable) {
        return customerRepo.findByUserAndIsActive(user, isActive, pageable);
    }

    @Override
    public List<Customer> findByUserAndFullName(User user, String firstName, String lastName) {
        return customerRepo.findByUserAndFirstNameAndLastName(user, firstName, lastName);
    }

    @Override
    public Customer findById(long id) {
        return customerRepo.findOne(id);
    }
}
