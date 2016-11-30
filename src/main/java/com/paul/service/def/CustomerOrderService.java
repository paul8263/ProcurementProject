package com.paul.service.def;

import com.paul.domain.Customer;
import com.paul.domain.CustomerOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 *
 * Customer Order DAO.
 */
public interface CustomerOrderService {
    /**
     * Find all customer order owned by the given customer.
     * @param customer Customer object.
     * @return List of customer orders owned by the given customer.
     */
    List<CustomerOrder> findAllByCustomer(Customer customer);

    /**
     * FInd all customer orders with given active state and belongs to the specific customer.
     * @param isActive The active state.
     * @param customer Customer object.
     * @return List of customer orders with given active state and belongs to the specific customer.
     */
    List<CustomerOrder> findAllByCustomer(boolean isActive, Customer customer);

    /**
     * Find all customer orders belonging to the given customer and page request.
     * @param customer Customer object.
     * @param pageable Page request.
     * @return All customer orders belonging to the given customer wrapped in page slice.
     */
    Page<CustomerOrder> findAllByCustomer(Customer customer, Pageable pageable);

    /**
     * Find all customer orders with given active state, belonging to specific customer and wrapped in page request.
     * @param isActive The active state.
     * @param customer Customer object.
     * @param pageable Page request.
     * @return all customer orders with given active state, belonging to specific customer in page slice.
     */
    Page<CustomerOrder> findAllByCustomer(boolean isActive, Customer customer, Pageable pageable);

    /**
     * Find the customer by customer ID.
     * @param id ID
     * @return The customer with the given ID.
     */
    CustomerOrder findById(long id);

    /**
     * Save the customer order.
     * @param customerOrder Customer order object to save.
     */
    void saveCustomerOrder(CustomerOrder customerOrder);

    /**
     * Set the active state for the given customer order.
     * @param customerOrder Customer order object.
     * @param isActive The active state.
     */
    void setActiveState(CustomerOrder customerOrder, boolean isActive);

    /**
     * Detete the given customer order.
     * @param customerOrder Customer order object.
     */
    void deleteCustomerOrder(CustomerOrder customerOrder);
}
