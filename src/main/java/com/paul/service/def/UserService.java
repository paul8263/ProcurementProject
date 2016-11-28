package com.paul.service.def;

/**
 * Created by paulzhang on 28/11/2016.
 */
public interface UserService {
    boolean login(String email, String password);
    void signUp(String email, String password);
    void changePassword(String email, String oldPassword, String newPassword);
}
