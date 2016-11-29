package com.paul.service.def;

import com.paul.domain.Customer;
import com.paul.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 *
 * Customer DAO
 */
public interface CustomerService {
    /**
     * Create a new customer or edit an existing customer.
     *
     * @param customer Customer object.
     */
    void saveCustomer(Customer customer);

    /**
     * Set the active status for the specified customer.
     *
     * @param customer Customer object.
     * @param isActive The active state.
     */
    void setActiveState(Customer customer, boolean isActive);

    /**
     * Remove customer from database.
     *
     * @param customer Customer to be removed.
     */
    void deleteCustomer(Customer customer);

    /**
     * Find all customers.
     *
     * @return All customers in list.
     */
    List<Customer> findAll();

    /**
     * Find all active customers or nonactive customers.
     * @param isActive Customer active state.
     * @return All customers with specified active state.
     */
    List<Customer> findAll(boolean isActive);

    /**
     * Find all customers with pageable request.
     *
     * @param pageable Pageable request.
     * @return All customers wrapped in page slice.
     */
    Page<Customer> findAll(Pageable pageable);

    /**
     * Find customers with specified active state with pageable request.
     *
     * @param isActive The active state.
     * @param pageable Pageable request.
     * @return Customers wrapped in page slice, with the specified active state.
     */
    Page<Customer> findAll(boolean isActive, Pageable pageable);

    /**
     * Find all customer with specified first name and last name.
     *
     * @param firstName Customer's first name.
     * @param lastName Customer's last name.
     * @return List of customers with specified first name and last name.
     */
    List<Customer> findByFullName(String firstName, String lastName);

    /**
     * Find all customers for the specific user.
     *
     * @param user User object.
     * @return List of customers that belongs to this user.
     */
    List<Customer> findByUser(User user);

    /**
     * Find all customer with specified active state and belong to the user.
     *
     * @param isActive The active state.
     * @param user User object.
     * @return List of customers with specified active state and belong to the specified user.
     */
    List<Customer> findByUser(boolean isActive, User user);

    /**
     * Find all customers belong to specified user with pageable request.
     *
     * @param user User object.
     * @param pageable Pageable request.
     * @return Customers in paged slice and belong to the specified user.
     */
    Page<Customer> findByUser(User user, Pageable pageable);

    /**
     * Find customers with specified active state and belong to one user with pageable request.
     * @param isActive The active state.
     * @param user User object.
     * @param pageable Pageable request.
     * @return Customers wrapped in page slice, with specified active state and belong to one user.
     */
    Page<Customer> findByUser(boolean isActive, User user, Pageable pageable);

    /**
     * Find customers with given first name and last name and belong to the specified user.
     *
     * @param user User object.
     * @param firstName Customer's first name.
     * @param lastName Customer's last name.
     * @return List of customers with given first name and last name and belong to the specified user.
     */
    List<Customer> findByUserAndFullName(User user, String firstName, String lastName);

    /**
     * Find the customer by ID
     * @param id Customer ID
     * @return Customer with the specified ID
     */
    Customer findById(long id);

}
