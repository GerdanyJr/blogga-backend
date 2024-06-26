package com.github.GerdanyJr.blogApi.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id
    private Integer id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;
    private String[] tags;
    private Integer reactions;
    private String src;
    private LocalDateTime publishDate;

    public Post() {
    }

    public Post(Integer id, String title, String body, String[] tags, Integer reactions, String src) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.tags = tags;
        this.reactions = reactions;
        this.src = src;
        publishDate = LocalDateTime.now();
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Integer getReactions() {
        return reactions;
    }

    public void setReactions(Integer reactions) {
        this.reactions = reactions;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

}