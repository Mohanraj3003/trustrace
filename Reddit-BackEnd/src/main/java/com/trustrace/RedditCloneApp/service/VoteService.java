package com.trustrace.RedditCloneApp.service;

import com.trustrace.RedditCloneApp.dto.VoteRequest;
import com.trustrace.RedditCloneApp.exception.AllReadyExistsException;
import com.trustrace.RedditCloneApp.model.Post;
import com.trustrace.RedditCloneApp.model.User;
import com.trustrace.RedditCloneApp.model.Vote;
import com.trustrace.RedditCloneApp.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VoteService {

    @Autowired
    PostService postService;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    UserService userService;

    public void vote(VoteRequest voteRequest){
        Post post = postService.getOnePost(voteRequest.getPostId());
        User user = userService.getOneUser(voteRequest.getUserName());

        if(voteRepository.existsById(voteRequest.getUserName())){
            Vote oldVote = voteRepository.findById(voteRequest.getUserName()).get();
            if(oldVote.getVoteType().equals(voteRequest.getVoteType())){
                throw new AllReadyExistsException("You have already "+voteRequest.getVoteType()+"'d for this post");
            }else {
                oldVote.setVoteType(voteRequest.getVoteType());
                post.setVoteCount(post.getVoteCount()+(voteType(voteRequest.getVoteType())));
            }
            voteRepository.save(oldVote);
        }else{

            Vote newVote = new Vote(voteRequest.getUserName(), voteRequest.getVoteType(), voteRequest.getPostId());
            voteRepository.save(newVote);
            post.setVoteCount(post.getVoteCount()+(voteType(voteRequest.getVoteType())));
        }

        postService.savePost(post);


    }

    public Integer voteType(String type){
        if (type.equals("DOWNVOTE")) {
            return -1;
        }else if (type.equals("UPVOTE")) {
            return 1;
        }
        return 0;
    }

}
