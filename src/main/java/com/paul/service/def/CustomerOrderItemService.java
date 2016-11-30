package com.paul.service.def;

import com.paul.domain.CustomerOrder;
import com.paul.domain.CustomerOrderItem;

import java.util.List;

/**
 * Created by paulzhang on 29/11/2016.
 *
 * Customer Order Item DAO.
 */
public interface CustomerOrderItemService {
    /**
     * Save the given customer order item.
     * @param customerOrderItem Customer order item object.
     */
    void save(CustomerOrderItem customerOrderItem);

    /**
     * Delete the given customer order item.
     * @param customerOrderItem Customer order item object.
     */
    void delete(CustomerOrderItem customerOrderItem);

    /**
     * Find the customer order item with the given id.
     * @param id ID
     * @return The customer order item with the given id.
     */
    CustomerOrderItem findById(long id);

    /**
     * Find all customer order items belonging to the given customer order.
     * @param customerOrder Customer order object.
     * @return List of customer order items belonging to the given customer order.
     */
    List<CustomerOrderItem> findAll(CustomerOrder customerOrder);
}
