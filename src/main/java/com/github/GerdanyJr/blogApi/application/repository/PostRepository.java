package com.github.GerdanyJr.blogApi.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.GerdanyJr.blogApi.domain.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
