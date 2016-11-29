package com.paul.service.repo;

import com.paul.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by paulzhang on 27/11/2016.
 */
public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findByIsActive(boolean isActive);
    Page<User> findByIsActive(boolean isActive, Pageable pageable);
}
