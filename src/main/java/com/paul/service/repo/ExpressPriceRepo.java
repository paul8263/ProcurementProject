package com.paul.service.repo;

import com.paul.domain.ExpressCompany;
import com.paul.domain.ExpressPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by paulzhang on 1/12/2016.
 */
public interface ExpressPriceRepo extends JpaRepository<ExpressPrice, Long> {
    List<ExpressPrice> findByExpressCompany(ExpressCompany expressCompany);
    Page<ExpressPrice> findByExpressCompany(ExpressCompany expressCompany, Pageable pageable);
}
