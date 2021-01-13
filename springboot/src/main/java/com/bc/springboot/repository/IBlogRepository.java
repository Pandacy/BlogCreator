package com.bc.springboot.repository;

import com.bc.springboot.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Blog findByUserId(int user_id);
}
