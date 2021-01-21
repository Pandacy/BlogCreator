package com.bc.springboot.service;

import com.bc.springboot.model.Blog;
import com.bc.springboot.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    private static IBlogRepository blogRepository;

    public BlogService(IBlogRepository repository)
    {
        blogRepository = repository;
    };

    public void AddBlog(Blog blog)
    {
        blogRepository.save(blog);
    }

    public List<Blog> getBlog()
    {
        return blogRepository.findAll();
    }

    public Blog getBlogById(int id)
    {
        return blogRepository.findById(id).orElse(null);
    }

    public Blog getByUserId(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    public String deleteBlog(int id){
        blogRepository.deleteById(id);
        return "Object Deleted";
    }

    public Blog updateBlog(Blog blog){
        Blog blogData = blogRepository.findById(blog.getId()).orElse(null);
        blogData.setTitle(blog.getTitle());
        blogData.setDescription(blog.getDescription());
        return blogRepository.save(blogData);
    }
}
