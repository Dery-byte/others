package com.example.blogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogApp.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
