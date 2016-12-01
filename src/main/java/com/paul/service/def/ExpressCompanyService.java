package com.paul.service.def;

import com.paul.domain.ExpressCompany;
import com.paul.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 *
 * Express Company DAO.
 */
public interface ExpressCompanyService {
    /**
     * Save One express company.
     * @param expressCompany Express company Object.
     */
    void save(ExpressCompany expressCompany);

    /**
     * Delete one express company.
     * @param expressCompany Express company to delete;
     */
    void delete(ExpressCompany expressCompany);

    /**
     * Set the express company with the provided active state.
     * @param expressCompany Express company object.
     * @param isActive Active state.
     */
    void setActiveState(ExpressCompany expressCompany, boolean isActive);

    /**
     * Find all express companies by user.
     * @param user User object.
     * @return List of express companies owned by provided user.
     */
    List<ExpressCompany> findAll(User user);

    /**
     * Find all express companies by user and the given active state.
     * @param isActive Active state.
     * @param user User object.
     * @return List of express companies by user and the given active state.
     */
    List<ExpressCompany> findAll(boolean isActive, User user);

    /**
     * Find express companies by user with page request.
     * @param user Use object.
     * @param pageable Page request.
     * @return Express companies by user with page request wrapped in a page slice.
     */
    Page<ExpressCompany> findAll(User user, Pageable pageable);

    /**
     * Find express companies by user with the given active state with page request.
     * @param isActive Active state.
     * @param user User object.
     * @param pageable Page request.
     * @return express companies by user with the given active state in a page slice.
     */
    Page<ExpressCompany> findAll(boolean isActive, User user, Pageable pageable);

    /**
     * Find one express company by ID.
     * @param id ID.
     * @return The express company with the given ID.
     */
    ExpressCompany findById(long id);
}
