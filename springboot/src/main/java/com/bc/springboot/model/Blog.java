package com.bc.springboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="Blog")
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String title;

    private String description;

    @OneToOne
    @JoinColumn(name="userId", unique = true)
    //@RestResource(path = "userBlog", rel="user")
    private User user;

    @OneToOne
    private BlogLayout blogLayout;

    public Blog(){

    }

    public Blog(Blog blog){
        this.id = blog.id;
        this.title = blog.title;
        this.description = blog.description;
        this.user = blog.user;
        this.blogLayout = blog.blogLayout;
        //this.comment = blog.comment;
    }

    public Blog(String title, String description, User user){
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public Blog(String title, String description){
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
