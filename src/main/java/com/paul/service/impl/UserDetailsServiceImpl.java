package com.paul.service.impl;

import com.paul.domain.User;
import com.paul.service.def.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by paulzhang on 29/11/2016.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByEmail(s);
        if (user == null) throw new UsernameNotFoundException("User with email: " + s + " does not exist");
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
        List<GrantedAuthority> grantedAuthorityList = Collections.singletonList(grantedAuthority);
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                grantedAuthorityList);
    }
}
