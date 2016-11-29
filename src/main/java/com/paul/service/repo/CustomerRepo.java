package com.paul.service.repo;

import com.paul.domain.Customer;
import com.paul.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 */
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
    List<Customer> findByIsActive(boolean isActive);
    Page<Customer> findByIsActive(boolean isActive, Pageable pageable);
    List<Customer> findByUser(User user);
    Page<Customer> findByUser(User user, Pageable pageable);
    List<Customer> findByUserAndIsActive(User user, boolean isActive);
    Page<Customer> findByUserAndIsActive(User user, boolean isActive, Pageable pageable);
    List<Customer> findByUserAndFirstNameAndLastName(User user, String firstName, String lastName);
}
