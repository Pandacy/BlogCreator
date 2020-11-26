package com.bc.springboot.model;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Account")
public class Account {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String country;

    private String firstname;

    private String lastname;

    private Date birthday;

    @OneToOne
    @JoinColumn(name = "user_id")
    @RestResource(path = "userAccount", rel="user")
    private User user;

    public Account(){

    }

    public Account(Account account){
        this.id = account.id;
        this.country = account.country;
        this.firstname = account.firstname;
        this.lastname = account.lastname;
        this.birthday = account.birthday;
    }

    public Account(Integer id, String country, String firstname, String lastname, Date birthday){
        this.id = id;
        this.country = country;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
