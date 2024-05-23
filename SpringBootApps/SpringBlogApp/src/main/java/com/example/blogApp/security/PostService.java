package com.example.blogApp.security;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.example.blogApp.dto.PostDto;
import com.example.blogApp.exception.PostNotFoundException;
import com.example.blogApp.model.Post;
import com.example.blogApp.repository.PostRepository;
import com.example.blogApp.service.AuthService;

@Service
public class PostService {

	@Autowired
	private AuthService authService;
	@Autowired
	private PostRepository postRepository;
	
	
	public void creatPost(PostDto postDto) {
		Post post = new Post();
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
	User username	= authService.getCurrentUser().orElseThrow(()-> new IllegalArgumentException("No user logged in"));
		post.setCreatedOn(Instant.now());
		post.setUsername(username.getUsername());
		postRepository.save(post);
	}


	public List<PostDto> showAllPosts() {
List<Post> posts = postRepository.findAll();
return posts.stream().map(this::mapFromPostToDto).toList();
	}
	
	public void createPost(PostDto postDto) {
		Post post = mapFromDtoToPost(postDto);
		postRepository.save(post);
	}


	private PostDto mapFromPostToDto(Post post) {
 PostDto postDto = new PostDto();
 postDto.setId(post.getId());
 postDto.setTitle(post.getTitle());
 postDto.setContent(post.getContent());
 postDto.setUsername(post.getUsername());
return postDto;
	}

	private Post mapFromDtoToPost(PostDto postDto) {
		 Post post = new Post();
		 post.setId(postDto.getId());
		 post.setTitle(postDto.getTitle());
		 post.setContent(postDto.getContent());
		 User LoggedUnUser = authService.getCurrentUser().orElseThrow(()-> 
		 new IllegalArgumentException("User Not found"));
		 post.setUsername(LoggedUnUser.getUsername());
		 post.setCreatedOn(Instant.now());
		 post.setUpdatedOn(Instant.now());
		return post;
			}

	public PostDto readSinglePost(Long id) {
Post post = postRepository.findById(id).orElseThrow(()-> new PostNotFoundException("For id " + id));
		return mapFromPostToDto(post);
	}
}
  