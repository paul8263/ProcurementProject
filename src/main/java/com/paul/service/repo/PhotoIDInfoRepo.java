package com.paul.service.repo;

import com.paul.domain.Customer;
import com.paul.domain.PhotoIDInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by paulzhang on 29/11/2016.
 */
public interface PhotoIDInfoRepo extends JpaRepository<PhotoIDInfo, Long> {
    List<PhotoIDInfo> findByCustomer(Customer customer);
}
