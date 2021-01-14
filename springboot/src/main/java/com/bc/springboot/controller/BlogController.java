package com.bc.springboot.controller;

import com.bc.springboot.model.Blog;
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

    @GetMapping(path = "/{name}")
    public ResponseEntity<Blog> getBlogById(@PathVariable final String name) {
        User user = userService.getUserByName(name);
        Blog blog = blogService.getByUserId(user.getId());
        return ResponseEntity.ok(blogService.getByUserId(user.getId()));
    }

    @GetMapping
    public ResponseEntity<List<Blog>> getBlog(){
        List<Blog> allBlogs = blogService.getBlog();
        return ResponseEntity.ok(allBlogs);
    }

    @PostMapping
    public ResponseEntity<Blog> create(@RequestBody final Blog blogFromRequest) {
        Blog blog = new Blog(blogFromRequest);
        User user = userService.getUserByName(blog.getUser().getName());
        blog.setUser(user);
        blogService.AddBlog(blog);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(blogService.getBlogById(blog.getId())).toUri();
        return ResponseEntity.created(uri).body(blog);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Blog> put(@RequestBody final Blog blogFromRequest, @PathVariable final int id) {
        Blog blog = new Blog(blogFromRequest);
        blog.setId(id);
        blogService.updateBlog(blog);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(blogService.getBlogById(blog.getId())).toUri();
        return ResponseEntity.created(uri).body(blog);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<List<Blog>> delete(@PathVariable final int id){
        blogService.deleteBlog(id);
        List<Blog> allBlog = blogService.getBlog();
        return ResponseEntity.ok(allBlog);
    }
}
