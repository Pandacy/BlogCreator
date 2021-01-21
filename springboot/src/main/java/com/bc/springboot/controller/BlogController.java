package com.bc.springboot.controller;

import com.bc.springboot.model.Blog;
import com.bc.springboot.model.BlogModel;
import com.bc.springboot.model.User;
import com.bc.springboot.service.BlogService;
import com.bc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/blog", produces = "application/json")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    public BlogController(){

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable final Integer id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getBlog(){
        List<Blog> allBlogs = blogService.getBlog();
        return ResponseEntity.ok(allBlogs);
    }

    @PostMapping
    public ResponseEntity<Blog> create(@RequestBody final BlogModel blogFromRequest) {
        Blog blog = new Blog(blogFromRequest.getTitle(), blogFromRequest.getDescription());
        blog.setUser(userService.getUserByName(blogFromRequest.getUser().getName()));
        blogService.AddBlog(blog);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(blog.getId()).toUri();
        return ResponseEntity.created(uri).body(blog);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Blog> put(@RequestBody final BlogModel blogFromRequest, @PathVariable final int id) {
        Blog blog = new Blog(blogFromRequest.getTitle(), blogFromRequest.getDescription());
        if (userService.isAuthorized(blogFromRequest.getUser().getToken()))
        {
            blog.setId(id);
            blogService.updateBlog(blog);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(blog.getId()).toUri();
            return ResponseEntity.created(uri).body(blog);
        }
        return ResponseEntity.badRequest().body(blog);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<List<Blog>> delete(@PathVariable final int id){
        blogService.deleteBlog(id);
        List<Blog> allBlog = blogService.getBlog();
        return ResponseEntity.ok(allBlog);
    }
}
