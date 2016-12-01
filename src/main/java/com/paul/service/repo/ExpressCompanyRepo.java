package com.paul.service.repo;

import com.paul.domain.ExpressCompany;
import com.paul.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by paulzhang on 30/11/2016.
 */
public interface ExpressCompanyRepo extends JpaRepository<ExpressCompany, Long> {
    List<ExpressCompany> findByUser(User user);
    Page<ExpressCompany> findByUser(User user, Pageable pageable);
    List<ExpressCompany> findByUserAndIsActive(User user, boolean isActive);
    Page<ExpressCompany> findByUserAndIsActive(User user, boolean isActive, Pageable pageable);
}
