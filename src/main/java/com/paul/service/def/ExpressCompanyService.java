package com.paul.service.def;

import com.paul.domain.ExpressCompany;
import com.paul.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by paulzhang on 28/11/2016.
 */
public interface ExpressCompanyService {
    void saveExpressCompany(User user, ExpressCompany expressCompany);

    void setExpressCompanyActiveState(ExpressCompany expressCompany, boolean isActive);

    List<ExpressCompany> findAll(User user);

    List<ExpressCompany> findAll(boolean isActive, User user);

    Page<ExpressCompany> findAll(User user, Pageable pageable);

    Page<ExpressCompany> findAll(boolean isActive, User user, Pageable pageable);

    ExpressCompany findById(long id);
}
