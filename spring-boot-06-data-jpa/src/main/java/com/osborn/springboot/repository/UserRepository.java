package com.osborn.springboot.repository;

import com.osborn.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-13 21:55
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
