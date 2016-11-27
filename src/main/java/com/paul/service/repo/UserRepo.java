package com.paul.service.repo;

import com.paul.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by paulzhang on 27/11/2016.
 */
public interface UserRepo extends JpaRepository<User, Long> {

}