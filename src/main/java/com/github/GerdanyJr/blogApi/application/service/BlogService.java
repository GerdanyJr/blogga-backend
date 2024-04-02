package com.github.GerdanyJr.blogApi.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.GerdanyJr.blogApi.application.in.DogApiClient;
import com.github.GerdanyJr.blogApi.application.in.DummyJsonClient;
import com.github.GerdanyJr.blogApi.domain.dto.response.CommentResponse;
import com.github.GerdanyJr.blogApi.domain.dto.response.DogApiResponse;
import com.github.GerdanyJr.blogApi.domain.dto.response.PostResponse;
import com.github.GerdanyJr.blogApi.domain.model.ShowcasePost;
import com.github.GerdanyJr.blogApi.mapper.PostMapper;

@Service
public class BlogService {
    private final DummyJsonClient dummyJsonClient;
    private final DogApiClient dogApiClient;

    public BlogService(DummyJsonClient dummyJsonClient, DogApiClient dogApiClient) {
        this.dummyJsonClient = dummyJsonClient;
        this.dogApiClient = dogApiClient;
    }

    public CommentResponse getComments(Integer postId) {
        return dummyJsonClient.getComments(postId);
    }

    public List<ShowcasePost> getPosts(Integer limit) {
        PostResponse postResponse = dummyJsonClient.getPosts(limit);
        DogApiResponse dogApiResponse = dogApiClient.getRandomImages(limit);
        return PostMapper
                .fromDtoToShowcasePost(postResponse, dogApiResponse);
    }
}
