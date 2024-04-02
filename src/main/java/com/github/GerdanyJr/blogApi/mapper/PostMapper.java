package com.github.GerdanyJr.blogApi.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.github.GerdanyJr.blogApi.domain.dto.response.CommentResponse;
import com.github.GerdanyJr.blogApi.domain.dto.response.DogApiResponse;
import com.github.GerdanyJr.blogApi.domain.dto.response.PostResponse;
import com.github.GerdanyJr.blogApi.domain.model.Post;
import com.github.GerdanyJr.blogApi.domain.model.ShowcasePost;

public class PostMapper {
    public static Post fromDtoToPost(PostResponse postResponse, DogApiResponse dogApiResponse,
            CommentResponse commentResponse) {
        Post returnedPost = new Post();
        for (int i = 0; i < postResponse.posts().size(); i++) {
            Post tempPost = postResponse.posts().get(i);
            returnedPost.setId(tempPost.getId());
            returnedPost.setTitle(tempPost.getTitle());
            returnedPost.setBody(tempPost.getBody());
            returnedPost.setTags(tempPost.getTags());
            returnedPost.setReactions(tempPost.getReactions());
            returnedPost.setSrc(dogApiResponse.message()[i]);
            returnedPost.setComments(commentResponse.comments());
        }
        return returnedPost;
    }

    public static List<ShowcasePost> fromDtoToShowcasePost(PostResponse postResponse, DogApiResponse dogApiResponse) {
        List<ShowcasePost> returnedPosts = new ArrayList<>();
        for (int i = 0; i < postResponse.posts().size(); i++) {
            Post tempPost = postResponse.posts().get(i);
            ShowcasePost newPost = new ShowcasePost();
            newPost.setId(tempPost.getId());
            newPost.setTitle(tempPost.getTitle());
            newPost.setBody(tempPost.getBody());
            newPost.setTags(tempPost.getTags());
            newPost.setSrc(dogApiResponse.message()[i]);
            newPost.setPublishDate(LocalDateTime.now());
            returnedPosts.add(newPost);
        }
        return returnedPosts;
    }
}