package com.github.GerdanyJr.blogApi;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.github.GerdanyJr.blogApi.application.in.DogApiClient;
import com.github.GerdanyJr.blogApi.application.in.DummyJsonClient;
import com.github.GerdanyJr.blogApi.application.repository.PostRepository;
import com.github.GerdanyJr.blogApi.domain.dto.response.DogApiResponse;
import com.github.GerdanyJr.blogApi.domain.dto.response.PostResponse;
import com.github.GerdanyJr.blogApi.domain.model.Post;
import com.github.GerdanyJr.blogApi.mapper.PostMapper;

@SpringBootApplication
@EnableFeignClients
public class BlogApiApplication implements CommandLineRunner {
	private final DummyJsonClient dummyJsonClient;
	private final DogApiClient dogApiClient;
	private final PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(BlogApiApplication.class, args);
	}

	public BlogApiApplication(DummyJsonClient dummyJsonClient, DogApiClient dogApiClient,
			PostRepository postRepository) {
		this.dummyJsonClient = dummyJsonClient;
		this.dogApiClient = dogApiClient;
		this.postRepository = postRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		List<Post> posts = getPosts(30);
		postRepository.saveAll(posts);
	}

	public List<Post> getPosts(Integer limit) {
		PostResponse postResponse = dummyJsonClient.getPosts(limit);
		DogApiResponse dogApiResponse = dogApiClient.getRandomImages(limit);
		return PostMapper
				.fromDtoToPost(postResponse, dogApiResponse);
	}

}
