package com.paul.service.impl;

import com.paul.domain.CustomerOrder;
import com.paul.domain.CustomerOrderItem;
import com.paul.service.def.CustomerOrderItemService;
import com.paul.service.repo.CustomerOrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by paulzhang on 29/11/2016.
 *
 * Customer order item service implementation.
 */
@Service
@Transactional(readOnly = true)
public class CustomerOrderItemServiceImpl implements CustomerOrderItemService {
    @Autowired
    private CustomerOrderItemRepo customerOrderItemRepo;

    @Transactional
    @Override
    public void save(CustomerOrderItem customerOrderItem) {
        customerOrderItemRepo.save(customerOrderItem);
    }

    @Transactional
    @Override
    public void delete(CustomerOrderItem customerOrderItem) {
        customerOrderItemRepo.delete(customerOrderItem);
    }

    @Override
    public CustomerOrderItem findById(long id) {
        return customerOrderItemRepo.findOne(id);
    }

    @Override
    public List<CustomerOrderItem> findAll(CustomerOrder customerOrder) {
        return customerOrderItemRepo.findByCustomerOrder(customerOrder);
    }
}
