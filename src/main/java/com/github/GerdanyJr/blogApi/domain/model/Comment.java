package com.github.GerdanyJr.blogApi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    private Integer id;
    private Integer postId;
    private String body;
    @ManyToOne
    private User user;

    public Comment() {
    }

    public Comment(Integer id, Integer postId, String body, User user) {
        this.id = id;
        this.postId = postId;
        this.body = body;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getuser() {
        return user;
    }

    public void setuser(User user) {
        this.user = user;
    }

}
