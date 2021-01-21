package com.bc.springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="Message")
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer votes;

    private String content;

    @ManyToOne
    @JoinColumn(name = "blogId")
    private Blog blog;

    @OneToMany
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    private List<Comment> comment;

    public Message(){

    }
    public Message(String content, Blog blog) {
        this.content = content;
        this.blog = blog;
    }

    public Message(Message message) {
        this.id = message.id;
        this.votes = message.votes;
        this.content = message.content;
        this.blog = message.blog;
        this.comment = message.comment;
    }

    public Message(String content){
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
