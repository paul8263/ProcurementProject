package com.paul.service.impl;

import com.paul.domain.ExpressCompany;
import com.paul.domain.User;
import com.paul.service.def.ExpressCompanyService;
import com.paul.service.repo.ExpressCompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by paulzhang on 1/12/2016.
 *
 * Express company service implementation.
 */
@Service
@Transactional(readOnly = true)
public class ExpressCompanyServiceImpl implements ExpressCompanyService {

    @Autowired
    private ExpressCompanyRepo expressCompanyRepo;

    @Transactional
    @Override
    public void save(ExpressCompany expressCompany) {
        expressCompanyRepo.save(expressCompany);
    }

    @Transactional
    @Override
    public void delete(ExpressCompany expressCompany) {
        expressCompanyRepo.delete(expressCompany);
    }

    @Transactional
    @Override
    public void setActiveState(ExpressCompany expressCompany, boolean isActive) {
        expressCompany.setActive(isActive);
        expressCompanyRepo.save(expressCompany);
    }

    @Override
    public List<ExpressCompany> findAll(User user) {
        return expressCompanyRepo.findByUser(user);
    }

    @Override
    public List<ExpressCompany> findAll(boolean isActive, User user) {
        return expressCompanyRepo.findByUserAndIsActive(user, isActive);
    }

    @Override
    public Page<ExpressCompany> findAll(User user, Pageable pageable) {
        return expressCompanyRepo.findByUser(user, pageable);
    }

    @Override
    public Page<ExpressCompany> findAll(boolean isActive, User user, Pageable pageable) {
        return expressCompanyRepo.findByUserAndIsActive(user, isActive, pageable);
    }

    @Override
    public ExpressCompany findById(long id) {
        return expressCompanyRepo.findOne(id);
    }
}
