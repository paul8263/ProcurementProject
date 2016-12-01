package com.paul.service.impl;

import com.paul.domain.Customer;
import com.paul.domain.ExpressOrder;
import com.paul.service.def.ExpressOrderService;
import com.paul.service.repo.ExpressOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by paulzhang on 1/12/2016.
 *
 * Express Order Service implementation.
 */
@Service
@Transactional(readOnly = true)
public class ExpressOrderServiceImpl implements ExpressOrderService {
    @Autowired
    private ExpressOrderRepo expressOrderRepo;

    @Transactional
    @Override
    public void save(ExpressOrder expressOrder) {
        expressOrderRepo.save(expressOrder);
    }

    @Transactional
    @Override
    public void delete(ExpressOrder expressOrder) {
        expressOrderRepo.delete(expressOrder);
    }

    @Transactional
    @Override
    public void setDelivered(ExpressOrder expressOrder, boolean isDelivered) {
        expressOrder.setDelivered(isDelivered);
        expressOrderRepo.save(expressOrder);
    }

    @Override
    public List<ExpressOrder> findAll(Customer customer) {
        return expressOrderRepo.findByCustomer(customer);
    }

    @Override
    public Page<ExpressOrder> findAll(Customer customer, Pageable pageable) {
        return expressOrderRepo.findByCustomer(customer, pageable);
    }

    @Override
    public List<ExpressOrder> findAll(Customer customer, boolean isDelivered) {
        return expressOrderRepo.findByCustomerAndIsDelivered(customer, isDelivered);
    }

    @Override
    public Page<ExpressOrder> findAll(Customer customer, boolean isDelivered, Pageable pageable) {
        return expressOrderRepo.findByCustomerAndIsDelivered(customer, isDelivered, pageable);
    }

    @Override
    public ExpressOrder findById(long id) {
        return expressOrderRepo.findOne(id);
    }
}
