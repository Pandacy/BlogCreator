package com.bc.springboot.model;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;

@Entity(name="Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String description;

    @OneToOne
    @JoinColumn(name="user_id")
    @RestResource(path = "userBlog", rel="user")
    private User user;

    @OneToOne
    private BlogLayout blogLayout;

    /*@OneToMany(mappedBy = "comment")
    private Comment comment;*/

    public Blog(){

    }

    public Blog(Blog blog){
        this.id = blog.id;
        this.name = blog.name;
        this.description = blog.description;
        this.user = blog.user;
        this.blogLayout = blog.blogLayout;
        //this.comment = blog.comment;
    }

    public Blog(Integer id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
