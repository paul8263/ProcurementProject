package com.paul.service.impl;

import com.paul.domain.ExpressCompany;
import com.paul.domain.ExpressPrice;
import com.paul.service.def.ExpressPriceService;
import com.paul.service.repo.ExpressPriceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by paulzhang on 1/12/2016.
 */
@Service
@Transactional(readOnly = true)
public class ExpressPriceServiceImpl implements ExpressPriceService {

    @Autowired
    private ExpressPriceRepo expressPriceRepo;

    @Transactional
    @Override
    public void save(ExpressPrice expressPrice) {
        expressPriceRepo.save(expressPrice);
    }

    @Transactional
    @Override
    public void delete(ExpressPrice expressPrice) {
        expressPriceRepo.delete(expressPrice);
    }

    @Override
    public List<ExpressPrice> findAll(ExpressCompany expressCompany) {
        return expressPriceRepo.findByExpressCompany(expressCompany);
    }

    @Override
    public Page<ExpressPrice> findAll(ExpressCompany expressCompany, Pageable pageable) {
        return expressPriceRepo.findByExpressCompany(expressCompany, pageable);
    }
}
