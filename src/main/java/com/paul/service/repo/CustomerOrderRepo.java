package com.paul.service.repo;

import com.paul.domain.Customer;
import com.paul.domain.CustomerOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 */
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, Long> {
    List<CustomerOrder> findByCustomer(Customer customer);
    Page<CustomerOrder> findByCustomer(Customer customer, Pageable pageable);
    List<CustomerOrder> findByIsActiveAndCustomer(boolean isActive, Customer customer);
    Page<CustomerOrder> findByIsActiveAndCustomer(boolean isActive, Customer customer, Pageable pageable);
}
