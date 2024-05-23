package com.example.test.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
public class Comment {
    @Id @GeneratedValue
    private Long id;

    private String message;

    @Value("${some.key:0}")
    private int upvote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    @ManyToOne
    private AuthCred authCred;

    @ManyToOne
    private Blog blog;

    public AuthCred getAuthCred() {
        return authCred;
    }

    public void setAuthCred(AuthCred authCred) {
        this.authCred = authCred;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
