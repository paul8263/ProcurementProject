package com.paul.service.def;

import com.paul.domain.ExpressOrder;
import com.paul.domain.ExpressOrderItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by paulzhang on 1/12/2016.
 *
 * Express Order Item DAO.
 */
public interface ExpressOrderItemService {
    /**
     * Save one express order item.
     * @param expressOrderItem Express order item to save.
     */
    void save(ExpressOrderItem expressOrderItem);

    /**
     * Delete one express order item.
     * @param expressOrderItem Express order item to delete.
     */
    void delete(ExpressOrderItem expressOrderItem);

    /**
     * Find one express order item by ID.
     * @param id ID.
     * @return Express order item with the given ID.
     */
    ExpressOrderItem findById(long id);

    /**
     * All express order items belonging to the given express order.
     * @param expressOrder Express order object.
     * @return List of express order items belonging to the given express order.
     */
    List<ExpressOrderItem> findAll(ExpressOrder expressOrder);

    /**
     * All express order items belonging to the given express order with a page request.
     * @param expressOrder Express order object.
     * @param pageable Page request.
     * @return Express order items belonging to the given express order wrapped in a page slice.
     */
    Page<ExpressOrderItem> findAll(ExpressOrder expressOrder, Pageable pageable);
}
