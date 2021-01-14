package com.bc.springboot.repository;

import com.bc.springboot.model.Blog;
import com.bc.springboot.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByBlogId(int blog_id);
}
