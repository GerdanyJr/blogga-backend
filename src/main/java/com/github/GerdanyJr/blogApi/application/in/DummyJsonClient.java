package com.github.GerdanyJr.blogApi.application.in;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.GerdanyJr.blogApi.domain.dto.response.PostResponse;

@FeignClient(value = "dummyJson", url = "https://dummyjson.com")
public interface DummyJsonClient {
    @GetMapping("/posts")
    public PostResponse getPosts(@RequestParam("limit") Integer limit);
}