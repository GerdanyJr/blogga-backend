package com.github.GerdanyJr.blogApi.application.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.GerdanyJr.blogApi.application.service.BlogService;
import com.github.GerdanyJr.blogApi.domain.dto.response.CommentResponse;
import com.github.GerdanyJr.blogApi.domain.model.ShowcasePost;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("blog")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("posts")
    public ResponseEntity<List<ShowcasePost>> getPosts(@PathParam("limit") Integer limit) {
        return ResponseEntity.ok(blogService.getPosts(limit));
    }

    @GetMapping("comments/{postId}")
    public ResponseEntity<CommentResponse> getComments(@PathVariable("postId") Integer postId) {
        return ResponseEntity.ok(blogService.getComments(postId));
    }

}
