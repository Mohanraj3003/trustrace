package com.trustrace.RedditCloneApp.service;

import com.trustrace.RedditCloneApp.dto.VoteRequest;
import com.trustrace.RedditCloneApp.exception.AllReadyExistsException;
import com.trustrace.RedditCloneApp.model.Post;
import com.trustrace.RedditCloneApp.model.User;
import com.trustrace.RedditCloneApp.model.Vote;
import com.trustrace.RedditCloneApp.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

        if(voteRepository.existsByUserName(voteRequest.getUserName()) && voteRepository.existsByPostId(voteRequest.getPostId())){
            System.out.println("Allready.."+voteRequest);
//            Vote oldVote = voteRepository.findById(voteRequest.getUserName()).get();
            Vote oldVote = voteRepository.findAllByUserNameAndPostId(voteRequest.getUserName(),voteRequest.getPostId());
            System.out.println("oldVotes:  "+oldVote);
            if(oldVote.getVoteType().equals(voteRequest.getVoteType())){
                System.out.println("samevote...");
                throw new AllReadyExistsException("You have already "+voteRequest.getVoteType()+"'d for this post");
            }else {
                System.out.println("new vote....");
                oldVote.setVoteType(voteRequest.getVoteType());
                post.setVoteCount(post.getVoteCount()+(voteType(voteRequest.getVoteType())));
            }
            voteRepository.save(oldVote);
        }else{
            System.out.println("newOne"+voteRequest);
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

    public List getVote(String user) {
        return voteRepository.findAllByUserName(user);
    }
}
