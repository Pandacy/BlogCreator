package com.bc.springboot.repository;

import com.bc.springboot.model.BlogLayout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogLayoutRepository extends JpaRepository<BlogLayout, Integer> {
}
