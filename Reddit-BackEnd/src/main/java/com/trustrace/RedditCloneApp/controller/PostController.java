package com.trustrace.RedditCloneApp.controller;

import com.trustrace.RedditCloneApp.dto.PostRequest;
import com.trustrace.RedditCloneApp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping()
    public ResponseEntity<?> getPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody PostRequest post){
        return new ResponseEntity<>(postService.createNewPost(post),HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<?> getPost(@PathVariable String id){
        return  new ResponseEntity<>(postService.getOnePost(id),HttpStatus.OK);
    }
}
