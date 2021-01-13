package com.bc.springboot.controller;

import com.bc.springboot.model.Comment;
import com.bc.springboot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/comment", produces = "application/json")
public class CommentController {
    @Autowired
    private CommentService commentService;

    public CommentController(){

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable final int id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @GetMapping
    public ResponseEntity<List<Comment>> getComment(){
        List<Comment> allComments = commentService.getComments();
        return ResponseEntity.ok(allComments);
    }

    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody final Comment commentFromRequest) {
        Comment comment = new Comment(commentFromRequest);
        commentService.AddComment(comment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(commentService.getCommentById(comment.getId())).toUri();
        return ResponseEntity.created(uri).body(comment);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Comment> put(@RequestBody final Comment commentFromRequest, @PathVariable final int id) {
        Comment comment = new Comment(commentFromRequest);
        comment.setId(id);
        commentService.updateComment(comment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(commentService.getCommentById(comment.getId())).toUri();
        return ResponseEntity.created(uri).body(comment);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<List<Comment>> delete(@PathVariable final int id){
        commentService.deleteComment(id);
        List<Comment> allComment = commentService.getComments();
        return ResponseEntity.ok(allComment);
    }
}
