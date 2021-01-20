package com.bc.springboot.model;

import javax.persistence.*;

@Entity(name="Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer votes;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "message_id", referencedColumnName = "id")
    private Message message;

    public Comment() {

    }

    public Comment(Comment comment) {
        this.id = comment.id;
        this.votes = comment.votes;
        this.content = comment.content;
        /*this.user = comment.user;
        this.message = comment.message;*/
    }

    public Comment(Integer id, Integer votes, String content){
        this.id = id;
        this.votes = votes;
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
}
