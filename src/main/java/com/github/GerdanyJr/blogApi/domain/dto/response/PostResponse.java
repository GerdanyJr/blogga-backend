package com.github.GerdanyJr.blogApi.domain.dto.response;

import java.util.List;

import com.github.GerdanyJr.blogApi.domain.model.Post;

public record PostResponse(
        List<Post> posts, Integer total, Integer skip, Integer limit) {

}
