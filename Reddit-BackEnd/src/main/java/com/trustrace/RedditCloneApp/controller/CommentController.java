package com.trustrace.RedditCloneApp.controller;


import com.trustrace.RedditCloneApp.dto.CommentRequest;
import com.trustrace.RedditCloneApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/{postid}")
    public ResponseEntity<?> getAll(@PathVariable String postid , @RequestBody CommentRequest comment){
        return new ResponseEntity<>(commentService.newComment(postid,comment), HttpStatus.CREATED);
    }
}
