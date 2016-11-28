package com.paul.service.repo;

import com.paul.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by paulzhang on 28/11/2016.
 */
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
