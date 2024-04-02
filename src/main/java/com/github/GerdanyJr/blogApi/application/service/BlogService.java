package com.github.GerdanyJr.blogApi.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.GerdanyJr.blogApi.application.repository.PostRepository;
import com.github.GerdanyJr.blogApi.domain.model.Post;

@Service
public class BlogService {
    private final PostRepository postRepository;

    public BlogService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Integer postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Não foi possível encontrar o post com id " + postId));
    }
}
