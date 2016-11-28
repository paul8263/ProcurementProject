package com.paul.service.def;

import com.paul.domain.User;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 *
 * User DAO
 */
public interface UserService {
    boolean login(String email, String password);
    void signUp(String email, String password);
    boolean isEmailDuplicated(String email);
    User findByEmail();
    void changePassword(String email, String oldPassword, String newPassword);
    void deleteUser(User user);

    List<User> findAll();
    List<User> findAll(boolean isActive);
}
