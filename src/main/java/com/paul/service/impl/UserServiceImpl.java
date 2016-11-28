package com.paul.service.impl;

import com.paul.service.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by paulzhang on 27/11/2016.
 */
@Service
public class UserServiceImpl {
    @Autowired
    private UserRepo userRepo;
}
