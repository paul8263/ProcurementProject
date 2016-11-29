package com.paul.service.def;

import com.paul.domain.Customer;
import com.paul.domain.PhotoIDInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by paulzhang on 29/11/2016.
 *
 * Photo ID Info DAO
 */
public interface PhotoIDInfoService {
    /**
     * Retrieve all photo ID info belonging to the given customer.
     * @param customer Customer object.
     * @return All photo ID info belonging to the given customer
     */
    List<PhotoIDInfo> findByCustomer(Customer customer);

    /**
     * Find the photo ID info object with the given ID.
     * @param id ID
     * @return Photo ID info object with the given ID.
     */
    PhotoIDInfo findById(long id);

    /**
     * Save the photo ID info.
     * @param photoIDInfo Photo ID info object.
     */
    void save(PhotoIDInfo photoIDInfo);

    /**
     * Delete the given photo ID info object.
     * @param photoIDInfo The photo ID info object to delete.
     */
    void delete(PhotoIDInfo photoIDInfo);

    /**
     * Create and copy the uploaded file to the storage.
     * @param file Uploaded multipart file.
     * @param pathToStorage Storage path.
     * @return Photo ID info object from uploaded multipart file.
     */
    PhotoIDInfo createFromMultipartFile(MultipartFile file, String pathToStorage);

    /**
     * Delete the file stored on the server corresponding to the given photo ID info object.
     * @param photoIDInfo Photo ID info object.
     * @return If true, the file corresponding to the given photo ID object was found and successfully deleted.
     */
    boolean deleteStoredFile(PhotoIDInfo photoIDInfo);
}
