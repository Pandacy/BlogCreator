package com.bc.springboot.repository;

import com.bc.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}
