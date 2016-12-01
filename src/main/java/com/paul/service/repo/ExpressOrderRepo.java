package com.paul.service.repo;

import com.paul.domain.Customer;
import com.paul.domain.ExpressOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by paulzhang on 1/12/2016.
 */
public interface ExpressOrderRepo extends JpaRepository<ExpressOrder, Long> {
    List<ExpressOrder> findByCustomer(Customer customer);
    Page<ExpressOrder> findByCustomer(Customer customer, Pageable pageable);
    List<ExpressOrder> findByCustomerAndIsDelivered(Customer customer, boolean isDelivered);
    Page<ExpressOrder> findByCustomerAndIsDelivered(Customer customer, boolean isDelivered, Pageable pageable);
}
