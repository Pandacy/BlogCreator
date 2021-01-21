package com.bc.springboot.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator= "native")
    @GenericGenerator(name= "native", strategy = "native")
    private Integer id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    private String token;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Blog blog;

    public User()
    {

    }

    public User(User user) {
        id = user.id;
        name = user.name;
        email = user.email;
        password = user.password;
        token = user.token;
    }

    // standard constructors
    public User(Integer id, String name, String email, String password, String token) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public User(String name, String email, String password, String token) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.token = token;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String token) {
        this.token = token;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}