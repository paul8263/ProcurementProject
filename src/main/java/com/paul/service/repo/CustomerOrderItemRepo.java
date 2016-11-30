package com.paul.service.repo;

import com.paul.domain.CustomerOrder;
import com.paul.domain.CustomerOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 */
public interface CustomerOrderItemRepo extends JpaRepository<CustomerOrderItem, Long> {
    List<CustomerOrderItem> findByCustomerOrder(CustomerOrder customerOrder);
}
