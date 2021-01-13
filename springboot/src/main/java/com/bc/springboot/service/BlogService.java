package com.bc.springboot.service;

import com.bc.springboot.model.Blog;
import com.bc.springboot.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    public void AddBlog(Blog blog)
    {
        iBlogRepository.save(blog);
    }

    public List<Blog> getBlog()
    {
        return iBlogRepository.findAll();
    }

    public Blog getBlogById(int id)
    {
        return iBlogRepository.findById(id).orElse(null);
    }

    public Blog getByUserId(int userid) {
        return iBlogRepository.findByUserId(userid);
    }

    public String deleteBlog(int id){
        iBlogRepository.deleteById(id);
        return "Object Deleted";
    }

    public Blog updateBlog(Blog blog){
        Blog blogData = iBlogRepository.findById(blog.getId()).orElse(null);
        blogData.setTitle(blog.getTitle());
        blogData.setDescription(blog.getDescription());
        return iBlogRepository.save(blogData);
    }
}
