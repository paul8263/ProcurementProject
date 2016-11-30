package com.paul.service.impl;

import com.paul.domain.Customer;
import com.paul.domain.CustomerOrder;
import com.paul.service.def.CustomerOrderService;
import com.paul.service.repo.CustomerOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 *
 * Customer Order Service implementation.
 */
@Service
@Transactional(readOnly = true)
public class CustomerOrderServiceImpl implements CustomerOrderService {
    @Autowired
    private CustomerOrderRepo customerOrderRepo;

    @Override
    public List<CustomerOrder> findAllByCustomer(Customer customer) {
        return customerOrderRepo.findByCustomer(customer);
    }

    @Override
    public List<CustomerOrder> findAllByCustomer(boolean isActive, Customer customer) {
        return customerOrderRepo.findByIsActiveAndCustomer(isActive, customer);
    }

    @Override
    public Page<CustomerOrder> findAllByCustomer(Customer customer, Pageable pageable) {
        return customerOrderRepo.findByCustomer(customer, pageable);
    }

    @Override
    public Page<CustomerOrder> findAllByCustomer(boolean isActive, Customer customer, Pageable pageable) {
        return customerOrderRepo.findByIsActiveAndCustomer(isActive, customer, pageable);
    }

    @Override
    public CustomerOrder findById(long id) {
        return customerOrderRepo.findOne(id);
    }

    @Transactional
    @Override
    public void saveCustomerOrder(CustomerOrder customerOrder) {
        customerOrderRepo.save(customerOrder);
    }

    @Transactional
    @Override
    public void setActiveState(CustomerOrder customerOrder, boolean isActive) {
        customerOrder.setActive(isActive);
        customerOrderRepo.save(customerOrder);
    }

    @Transactional
    @Override
    public void deleteCustomerOrder(CustomerOrder customerOrder) {
        customerOrderRepo.delete(customerOrder);
    }
}
