package com.paul.service.def;

import com.paul.domain.Customer;
import org.springframework.data.domain.Pageable;

/**
 * Created by paulzhang on 28/11/2016.
 */
public interface CustomerService {
    void createNewCustomer(Customer customer);

    void findAll();

    void findByPage(Pageable pageable);

    void findByFullName(String FirstName, String lastName);
}
