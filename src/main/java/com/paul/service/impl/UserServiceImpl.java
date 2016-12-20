package com.paul.service.impl;

import com.paul.domain.User;
import com.paul.service.def.UserService;
import com.paul.service.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by paulzhang on 27/11/2016.
 *
 * User service implementation
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    @Override
    public boolean login(String email, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                userDetails,
                password,
                userDetails.getAuthorities()
        );

        authenticationManager.authenticate(token);
        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean signUp(String email, String password) {
        if (!isEmailDuplicated(email)) {
            User user = new User();
            user.setEmail(email);
            user.setCreateDate(new Date());
            user.setPassword(passwordEncoder.encode(password));
            user.setActive(true);
            userRepo.save(user);

            logger.info("User with email {} created", email);

            return true;
        }
        return false;
    }

    @Override
    public boolean isEmailDuplicated(String email) {
        User user = userRepo.findByEmail(email);
        return user != null;
    }

    @Transactional
    @Override
    public void setActiveState(User user, boolean isActive) {
        user.setActive(isActive);
        userRepo.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Transactional
    @Override
    public boolean changePassword(String email, String oldPassword, String newPassword) {
        User user = findByEmail(email);
        if (null == user) return false;
        if (passwordEncoder.matches(oldPassword, user.getPassword())) {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepo.save(user);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public List<User> findAll(boolean isActive) {
        return userRepo.findByIsActive(isActive);
    }

    @Override
    public Page<User> findAll(boolean isActive, Pageable pageable) {
        return userRepo.findByIsActive(isActive, pageable);
    }

    @Override
    public User findById(long id) {
        return userRepo.findOne(id);
    }
}
