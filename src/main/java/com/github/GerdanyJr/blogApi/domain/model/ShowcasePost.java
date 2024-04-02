package com.github.GerdanyJr.blogApi.domain.model;

import java.time.LocalDateTime;

public class ShowcasePost {
    private Integer id;
    private String title;
    private String body;
    private String[] tags;
    private String src;
    private LocalDateTime publishDate;

    public ShowcasePost() {
    }

    public ShowcasePost(Integer id, String title, String body, String[] tags, String src, LocalDateTime publishDate) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.tags = tags;
        this.src = src;
        this.publishDate = publishDate;
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
