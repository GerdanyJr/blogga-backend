package com.github.GerdanyJr.blogApi.domain.dto.response;

import java.util.List;

import com.github.GerdanyJr.blogApi.domain.model.Comment;

public record CommentResponse(List<Comment> comments, Integer total, Integer skip, Integer limit) {

}
