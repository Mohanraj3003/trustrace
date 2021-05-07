package com.trustrace.RedditCloneApp.controller;

import com.trustrace.RedditCloneApp.dto.SubredditRequest;
import com.trustrace.RedditCloneApp.service.SubredditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subreddits")
public class SubredditController {

    @Autowired
    SubredditService subredditService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(subredditService.getAllSubreddit(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody SubredditRequest subredditRequest){
        return new ResponseEntity<>(subredditService.createNewSubreddit(subredditRequest),HttpStatus.CREATED);
    }

    @GetMapping("/{SubredditName}")
    public ResponseEntity<?> getOne(@PathVariable String SubredditName){
        return new ResponseEntity<>(subredditService.getOneSubreddit(SubredditName), HttpStatus.OK);
    }

}
