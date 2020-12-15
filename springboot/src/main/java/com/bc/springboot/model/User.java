package com.bc.springboot.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="User")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String name;

    private String email;

    private String password;

    /*@OneToMany
    private List<Report> report;

    @OneToOne
    private Blog blog;

    @OneToOne
    private Account account;*/

    public User()
    {

    }

    public User(User user) {
        id = user.id;
        name = user.name;
        email = user.email;
        password = user.password;
    }

    // standard constructors
    public User(Integer id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // standard getters and setters

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}