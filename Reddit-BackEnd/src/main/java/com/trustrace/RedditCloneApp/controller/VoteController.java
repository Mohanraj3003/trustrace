package com.trustrace.RedditCloneApp.controller;

import com.trustrace.RedditCloneApp.dto.VoteRequest;
import com.trustrace.RedditCloneApp.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    VoteService voteService;

    @PostMapping()
    public ResponseEntity<Void> vote(@RequestBody VoteRequest voteRequest){
        voteService.vote(voteRequest);
        return new  ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{user}")
    public ResponseEntity<?> getVote(@PathVariable String user){

        return new  ResponseEntity<>(voteService.getVote(user),HttpStatus.OK);
    }

}
