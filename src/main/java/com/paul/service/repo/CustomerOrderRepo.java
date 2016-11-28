package com.paul.service.repo;

import com.paul.domain.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by paulzhang on 28/11/2016.
 */
public interface CustomerOrderRepo extends JpaRepository<CustomerOrder, Long> {

}
