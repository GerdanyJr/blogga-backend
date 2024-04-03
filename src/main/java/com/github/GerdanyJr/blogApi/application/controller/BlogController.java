package com.github.GerdanyJr.blogApi.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.GerdanyJr.blogApi.application.service.BlogService;
import com.github.GerdanyJr.blogApi.domain.dto.response.PaginatedPostsResponse;
import com.github.GerdanyJr.blogApi.domain.model.Post;

@RestController
@RequestMapping("blog")
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("posts")
    public ResponseEntity<PaginatedPostsResponse> getPosts(@RequestParam Integer page) {
        return ResponseEntity.ok(blogService.getPosts(page));
    }

    @GetMapping("posts/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer postId) {
        return ResponseEntity.ok(blogService.getPostById(postId));
    }

}
