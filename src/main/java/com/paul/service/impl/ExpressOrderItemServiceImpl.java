package com.paul.service.impl;

import com.paul.domain.ExpressOrder;
import com.paul.domain.ExpressOrderItem;
import com.paul.service.def.ExpressOrderItemService;
import com.paul.service.repo.ExpressOrderItemRepo;
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
public class ExpressOrderItemServiceImpl implements ExpressOrderItemService {
    @Autowired
    private ExpressOrderItemRepo expressOrderItemRepo;

    @Transactional
    @Override
    public void save(ExpressOrderItem expressOrderItem) {
        expressOrderItemRepo.save(expressOrderItem);
    }

    @Transactional
    @Override
    public void delete(ExpressOrderItem expressOrderItem) {
        expressOrderItemRepo.delete(expressOrderItem);
    }

    @Override
    public ExpressOrderItem findById(long id) {
        return expressOrderItemRepo.findOne(id);
    }

    @Override
    public List<ExpressOrderItem> findAll(ExpressOrder expressOrder) {
        return expressOrderItemRepo.findByExpressOrder(expressOrder);
    }

    @Override
    public Page<ExpressOrderItem> findAll(ExpressOrder expressOrder, Pageable pageable) {
        return expressOrderItemRepo.findByExpressOrder(expressOrder, pageable);
    }
}
