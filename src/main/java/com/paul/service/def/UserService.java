package com.paul.service.def;

import com.paul.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 *
 * User DAO
 */
public interface UserService {

    /**
     * User login using email and password.
     * @param email User email.
     * @param password Use password.
     * @return If the login process is successful, return true.
     */
    boolean login(String email, String password);

    /**
     * Register new user.
     * @param email New user email.
     * @param password New user password.
     * @return If the sign up process is successful, return true.
     */
    boolean signUp(String email, String password);

    /**
     * Find out whether the given email has been registered.
     * @param email The given email address.
     * @return True if the given email address has already been registered.
     */
    boolean isEmailDuplicated(String email);

    /**
     * Set the active state for the given user.
     * @param user Use object.
     * @param isActive The active state.
     */
    void setActiveState(User user, boolean isActive);

    /**
     * Find the user with the given email address.
     * @param email The given email.
     * @return User object with the given email.
     */
    User findByEmail(String email);

    /**
     * Change user password.
     * @param email User email.
     * @param oldPassword User old password.
     * @param newPassword User new password.
     * @return True if old password is correct.
     */
    boolean changePassword(String email, String oldPassword, String newPassword);

    /**
     * Delete the given user.
     * @param user User object.
     */
    void deleteUser(User user);

    /**
     * Find all users.
     * @return All users.
     */
    List<User> findAll();

    /**
     * Find all users with page request.
     * @param pageable Page request.
     * @return Users wrapped in page slice.
     */
    Page<User> findAll(Pageable pageable);

    /**
     * Find all users with given active state.
     * @param isActive Active state.
     * @return All users with the given active state.
     */
    List<User> findAll(boolean isActive);

    /**
     * Find all users with the given active state and the page request.
     * @param isActive The active state.
     * @param pageable PAge request.
     * @return All users with the given active state wrapped in a page slice.
     */
    Page<User> findAll(boolean isActive, Pageable pageable);

    /**
     * Find the user with the given ID.
     * @param id ID.
     * @return The user with given ID.
     */
    User findById(long id);
}
