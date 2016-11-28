package com.paul.service.impl;

import com.paul.service.repo.CustomerOrderItemRepo;
import com.paul.service.repo.CustomerOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by paulzhang on 28/11/2016.
 */
@Service
public class CustomerOrderServiceImpl {
    @Autowired
    private CustomerOrderRepo customerOrderRepo;

    @Autowired
    private CustomerOrderItemRepo customerOrderItemRepo;

}
