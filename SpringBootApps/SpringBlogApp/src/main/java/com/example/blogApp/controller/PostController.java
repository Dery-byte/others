package com.example.blogApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogApp.dto.PostDto;
import com.example.blogApp.security.PostService;

@RestController
@RequestMapping("/api/post/")
public class PostController {
	
	@Autowired
	private PostService postService;
       
	@PostMapping("/sendPost")
	public String creatPost(@RequestBody PostDto postDto) {
		postService.creatPost(postDto);
		return "Your post was successful";
		
	}
	
	@GetMapping("/all")
	public List<PostDto> showAllPost(){
	return postService.showAllPosts();	
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<PostDto> getSinglePost(@PathVariable @RequestBody Long id){
	return new ResponseEntity<> (postService.readSinglePost(id), HttpStatus.OK);	
	}
	
	
}
