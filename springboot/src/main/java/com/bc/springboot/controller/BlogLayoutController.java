package com.bc.springboot.controller;

import com.bc.springboot.model.BlogLayout;
import com.bc.springboot.service.BlogLayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/bloglayout", produces = "application/json")
public class BlogLayoutController {
    @Autowired
    private BlogLayoutService blogLayoutService;

    public BlogLayoutController(){

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<BlogLayout> getBlogLayoutById(@PathVariable final int id) {
        return ResponseEntity.ok(blogLayoutService.getBlogLayoutById(id));
    }

    @GetMapping
    public ResponseEntity<List<BlogLayout>> getBlogLayout(){
        List<BlogLayout> allLayouts = blogLayoutService.getBlogLayout();
        return ResponseEntity.ok(allLayouts);
    }

    @PostMapping
    public ResponseEntity<BlogLayout> create(@RequestBody final BlogLayout blogLayoutFromRequest) {
        BlogLayout blogLayout = new BlogLayout(blogLayoutFromRequest);
        blogLayoutService.AddBlogLayout(blogLayout);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(blogLayoutService.getBlogLayoutById(blogLayout.getId())).toUri();
        return ResponseEntity.created(uri).body(blogLayout);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BlogLayout> put(@RequestBody final BlogLayout blogLayoutFromRequest, @PathVariable final int id) {
        BlogLayout blogLayout = new BlogLayout(blogLayoutFromRequest);
        blogLayout.setId(id);
        blogLayoutService.updateBloglayout(blogLayout);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(blogLayoutService.getBlogLayoutById(blogLayout.getId())).toUri();
        return ResponseEntity.created(uri).body(blogLayout);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<List<BlogLayout>> delete(@PathVariable final int id){
        blogLayoutService.deleteBlogLayout(id);
        List<BlogLayout> allLayouts = blogLayoutService.getBlogLayout();
        return ResponseEntity.ok(allLayouts);
    }
}