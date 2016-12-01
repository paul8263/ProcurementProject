package com.paul.service.def;

import com.paul.domain.ExpressCompany;
import com.paul.domain.ExpressPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by paulzhang on 1/12/2016.
 *
 * Express Price DAO.
 */
public interface ExpressPriceService {

    /**
     * Save one express price.
     * @param expressPrice Express price.
     */
    void save(ExpressPrice expressPrice);

    /**
     * Delete the given express price
     * @param expressPrice Express price object.
     */
    void delete(ExpressPrice expressPrice);

    /**
     * Find all express companies belonging to the express company.
     * @param expressCompany Express company object.
     * @return List of express companies belonging to the express company.
     */
    List<ExpressPrice> findAll(ExpressCompany expressCompany);

    /**
     * Find express companies belonging to the express company with page request.
     * @param expressCompany Express company object.
     * @param pageable Page request.
     * @return Express companies belonging to the express company wrapped in a page slice.
     */
    Page<ExpressPrice> findAll(ExpressCompany expressCompany, Pageable pageable);
}
