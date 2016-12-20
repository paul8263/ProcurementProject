package com.paul.service.impl;

import com.paul.domain.User;
import com.paul.service.def.UserHelper;
import com.paul.service.def.UserService;
import com.paul.web.exception.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by paulzhang on 20/12/2016.
 */
@Service
public class userHelperImpl implements UserHelper {
    @Autowired
    private UserService userService;

    @Override
    public User getUserFromAuthentication() throws ItemNotFoundException {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByEmail(email);
        if (null == user) throw new ItemNotFoundException("User with email: " + email + " does not exist");
        else return user;
    }
}
