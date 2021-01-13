package com.bc.springboot.service;

import com.bc.springboot.model.Comment;
import com.bc.springboot.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private ICommentRepository commentRepository;

    public void AddComment(Comment comment)
    {
        commentRepository.save(comment);
    }

    public List<Comment> getComments()
    {
        return commentRepository.findAll();
    }

    public Comment getCommentById(int id)
    {
        return commentRepository.findById(id).orElse(null);
    }

    public String deleteComment(int id){
        commentRepository.deleteById(id);
        return "Object Deleted";
    }

    public Comment updateComment(Comment comment){
        Comment commentData = commentRepository.findById(comment.getId()).orElse(null);
        commentData.setContent(comment.getContent());
        commentData.setVotes(comment.getVotes());
        return commentRepository.save(commentData);
    }
}
