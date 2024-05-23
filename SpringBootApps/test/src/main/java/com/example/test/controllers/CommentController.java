package com.example.test.controllers;

import com.example.test.models.Comment;
import com.example.test.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PatchMapping("/upvote/{commentId}")
    public ResponseEntity<String> upvoteComment(@PathVariable String commentId) {
        String id = commentId;

        if (id.isEmpty()) {
            return new ResponseEntity<>("invalid commentId", HttpStatus.BAD_REQUEST);
        }

        Long l = Long.parseLong(id);

        Comment comment = commentRepository.findById(l).get();

        int upvote = comment.getUpvote() + 1;
        comment.setUpvote(upvote);

        commentRepository.save(comment);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PatchMapping("/downvote/{commentId}")
    public ResponseEntity<String> downvoteComment(@PathVariable String commentId) {
        String id = commentId;

        if (id.isEmpty()) {
            return new ResponseEntity<>("invalid commentId", HttpStatus.BAD_REQUEST);
        }

        Long l = Long.parseLong(id);

        Comment comment = commentRepository.findById(l).get();

        int upvote = comment.getUpvote() - 1;
        comment.setUpvote(upvote);

        commentRepository.save(comment);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
