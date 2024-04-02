package com.github.GerdanyJr.blogApi.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.github.GerdanyJr.blogApi.domain.dto.response.DogApiResponse;
import com.github.GerdanyJr.blogApi.domain.dto.response.PostResponse;
import com.github.GerdanyJr.blogApi.domain.model.Post;

public class PostMapper {

    public static List<Post> fromDtoToPost(PostResponse postResponse, DogApiResponse dogApiResponse) {
        List<Post> returnedPosts = new ArrayList<>();
        for (int i = 0; i < postResponse.posts().size(); i++) {
            Post tempPost = postResponse.posts().get(i);
            Post newPost = new Post();
            newPost.setId(tempPost.getId());
            newPost.setTitle(tempPost.getTitle());
            newPost.setBody(tempPost.getBody());
            newPost.setTags(tempPost.getTags());
            newPost.setReactions(tempPost.getReactions());
            newPost.setSrc(dogApiResponse.message()[i]);
            newPost.setPublishDate(LocalDateTime.now());
            returnedPosts.add(newPost);
        }
        return returnedPosts;
    }
}