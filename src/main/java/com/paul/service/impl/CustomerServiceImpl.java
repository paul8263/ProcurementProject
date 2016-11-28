package com.paul.service.impl;

import com.paul.service.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by paulzhang on 28/11/2016.
 */
@Service
public class CustomerServiceImpl {
    @Autowired
    private CustomerRepo customerRepo;

}
