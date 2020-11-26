package com.bc.springboot.model;

import javax.persistence.*;

@Entity(name="Report")
public class Report {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Report(){

    }

    public Report(Report report){
        this.id = report.id;
        this.title = report.title;
        this.description = report.description;
        this.user = report.user;
    }

    public Report(Integer id, String title, String description){
        this.id = id;
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
}
