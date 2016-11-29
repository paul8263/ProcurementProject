package com.paul.service.def;

import com.paul.domain.Customer;
import com.paul.domain.CustomerOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 */
public interface CustomerOrderService {
    List<CustomerOrder> findAllByCustomer(Customer Customer);

    List<CustomerOrder> findAllByCustomer(boolean isActive, Customer customer);

    Page<CustomerOrder> findAllByCustomer(Customer customer, Pageable pageable);

    Page<CustomerOrder> findAllByCustomer(boolean isActive, Customer customer, Pageable pageable);

    CustomerOrder findById(long id);

    void saveCustomerOrder(Customer customer, CustomerOrder customerOrder);

    void setActiveState(CustomerOrder customerOrder, boolean isActive);

    void deleteCustomerOrder(CustomerOrder customerOrder);
}
