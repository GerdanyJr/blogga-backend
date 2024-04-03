package com.github.GerdanyJr.blogApi.domain.dto.response;

import java.util.List;
import com.github.GerdanyJr.blogApi.domain.model.Post;

public record PaginatedPostsResponse(
                List<Post> posts,
                Integer totalPages,
                Integer numberOfElements,
                long totalNumberOfElements,
                Integer actualPage,
                boolean empty) {

}
