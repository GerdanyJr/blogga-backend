package com.github.GerdanyJr.blogApi.application.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.github.GerdanyJr.blogApi.application.repository.PostRepository;
import com.github.GerdanyJr.blogApi.domain.dto.response.PaginatedPostsResponse;
import com.github.GerdanyJr.blogApi.domain.model.Post;

@Service
public class BlogService {
    private final PostRepository postRepository;
    private static final Integer PAGESIZE = 5;

    public BlogService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PaginatedPostsResponse getPosts(Integer page) {
        Page<Post> posts = postRepository.findAll(PageRequest.of(page, PAGESIZE));
        return new PaginatedPostsResponse(
                posts.getContent(),
                posts.getTotalPages(),
                posts.getNumberOfElements(),
                posts.getTotalElements(),
                posts.getNumber(),
                posts.isEmpty());
    }

    public Post getPostById(Integer postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o post com id " + postId));
    }
}
