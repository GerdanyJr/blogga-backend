package com.github.GerdanyJr.blogApi.application.in;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.GerdanyJr.blogApi.domain.dto.response.DogApiResponse;

@FeignClient(value = "dogApiClient", url = "https://dog.ceo/api")
public interface DogApiClient {
    @GetMapping("/breeds/image/random/{imageNumber}")
    public DogApiResponse getRandomImages(@PathVariable Integer imageNumber);
}
