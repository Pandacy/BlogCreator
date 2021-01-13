package com.bc.springboot.service;

import com.bc.springboot.model.BlogLayout;
import com.bc.springboot.repository.IBlogLayoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogLayoutService {
    @Autowired
    private IBlogLayoutRepository iBlogLayoutRepository;

    public void AddBlogLayout(BlogLayout blogLayout)
    {
        iBlogLayoutRepository.save(blogLayout);
    }

    public List<BlogLayout> getBlogLayout()
    {
        return iBlogLayoutRepository.findAll();
    }

    public BlogLayout getBlogLayoutById(int id)
    {
        return iBlogLayoutRepository.findById(id).orElse(null);
    }

    public String deleteBlogLayout(int id){
        iBlogLayoutRepository.deleteById(id);
        return "Object Deleted";
    }

    public BlogLayout updateBloglayout(BlogLayout blogLayout){
        BlogLayout blogData = iBlogLayoutRepository.findById(blogLayout.getId()).orElse(null);
        blogData.setColor(blogLayout.getColor());
        blogData.setFont(blogLayout.getFont());
        blogData.setFontSize(blogLayout.getFontSize());
        return iBlogLayoutRepository.save(blogData);
    }
}
