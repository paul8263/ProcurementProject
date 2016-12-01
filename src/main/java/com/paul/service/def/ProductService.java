package com.paul.service.def;

import com.paul.domain.Product;
import com.paul.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by paulzhang on 30/11/2016.
 * <p>
 * Product DAO.
 */
public interface ProductService {
    /**
     * Save product.
     *
     * @param product Product object.
     */
    void save(Product product);

    /**
     * Delete the given product.
     *
     * @param product Product object.
     */
    void delete(Product product);

    /**
     * Find the product with given ID.
     *
     * @param id ID.
     * @return Product with the given ID.
     */
    Product findById(long id);

    /**
     * Find all products.
     *
     * @return All products.
     */
    List<Product> findAll();

    /**
     * Find all products with page request.
     *
     * @param pageable Page request.
     * @return All products wrapped in a page slice.
     */
    Page<Product> findAll(Pageable pageable);

    /**
     * Find all products belonging to the given user.
     *
     * @param user User object.
     * @return List of products belonging to the given user.
     */
    List<Product> findAll(User user);

    /**
     * Find all products belonging to the given user with page request.
     *
     * @param user     User object.
     * @param pageable Page request.
     * @return All products belonging to the given user in a page slice.
     */
    Page<Product> findAll(User user, Pageable pageable);
}
