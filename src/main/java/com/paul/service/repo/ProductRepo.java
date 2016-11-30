package com.paul.service.repo;

import com.paul.domain.Product;
import com.paul.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by paulzhang on 30/11/2016.
 */
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByUser(User user);
    Page<Product> findByUser(User user, Pageable pageable);
}
