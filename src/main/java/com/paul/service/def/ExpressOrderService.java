package com.paul.service.def;

import com.paul.domain.Customer;
import com.paul.domain.ExpressOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 *
 * Express Order DAO.
 */
public interface ExpressOrderService {
    /**
     * Save one express order.
     * @param expressOrder Express order object.
     */
    void save(ExpressOrder expressOrder);

    /**
     * Delete one express order.
     * @param expressOrder Express order to delete.
     */
    void delete(ExpressOrder expressOrder);

    void setDelivered(ExpressOrder expressOrder, boolean isDelivered);

    List<ExpressOrder> findAll(Customer customer);

    Page<ExpressOrder> findAll(Customer customer, Pageable pageable);

    List<ExpressOrder> findAll(Customer customer, boolean isDelivered);

    Page<ExpressOrder> findAll(Customer customer, boolean isDelivered, Pageable pageable);

    ExpressOrder findById(long id);

}
