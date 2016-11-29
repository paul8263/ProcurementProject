package com.paul.service.impl;

import com.paul.domain.Customer;
import com.paul.domain.PhotoIDInfo;
import com.paul.service.def.PhotoIDInfoService;
import com.paul.service.repo.PhotoIDInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by paulzhang on 29/11/2016.
 */
@Transactional(readOnly = true)
@Service
public class PhotoIDInfoServiceImpl implements PhotoIDInfoService {

    @Autowired
    private PhotoIDInfoRepo photoIDInfoRepo;

    @Override
    public List<PhotoIDInfo> findByCustomer(Customer customer) {
        return photoIDInfoRepo.findByCustomer(customer);
    }

    @Override
    public PhotoIDInfo findById(long id) {
        return photoIDInfoRepo.findOne(id);
    }

    @Transactional
    @Override
    public void save(PhotoIDInfo photoIDInfo) {
        photoIDInfoRepo.save(photoIDInfo);
    }

    @Transactional
    @Override
    public void delete(PhotoIDInfo photoIDInfo) {
        photoIDInfoRepo.delete(photoIDInfo);
    }

    @Override
    public PhotoIDInfo createFromMultipartFile(MultipartFile file, String pathToStorage) {
//        Todo
        return null;
    }

    @Override
    public boolean deleteStoredFile(PhotoIDInfo photoIDInfo) {
//        Todo
        return false;
    }
}
