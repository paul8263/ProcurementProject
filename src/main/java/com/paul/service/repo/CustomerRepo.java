package com.paul.service.repo;

import com.paul.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 */
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
}
