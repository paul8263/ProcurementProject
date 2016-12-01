package com.paul.service.repo;

import com.paul.domain.ExpressOrder;
import com.paul.domain.ExpressOrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by paulzhang on 1/12/2016.
 */
public interface ExpressOrderItemRepo extends JpaRepository<ExpressOrderItem, Long> {
    List<ExpressOrderItem> findByExpressOrder(ExpressOrder expressOrder);
    Page<ExpressOrderItem> findByExpressOrder(ExpressOrder expressOrder, Pageable pageable);
}
