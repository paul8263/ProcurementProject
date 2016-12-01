package com.paul.service.impl;

import com.paul.domain.Product;
import com.paul.domain.User;
import com.paul.service.def.ProductService;
import com.paul.service.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by paulzhang on 30/11/2016.
 *
 * Product Service implementation.
 */
@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Transactional
    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Transactional
    @Override
    public void delete(Product product) {
        productRepo.delete(product);
    }

    @Override
    public Product findById(long id) {
        return productRepo.findOne(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public List<Product> findAll(User user) {
        return productRepo.findByUser(user);
    }

    @Override
    public Page<Product> findAll(User user, Pageable pageable) {
        return productRepo.findByUser(user, pageable);
    }
}
