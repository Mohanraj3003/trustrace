package com.trustrace.RedditCloneApp.service;

import com.trustrace.RedditCloneApp.dto.SubredditRequest;
import com.trustrace.RedditCloneApp.exception.ResourceNotFoundException;
import com.trustrace.RedditCloneApp.exception.AllReadyExistsException;
import com.trustrace.RedditCloneApp.model.Subreddit;
import com.trustrace.RedditCloneApp.repository.SubredditRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Builder
public class SubredditService {

    @Autowired
    SubredditRepository subredditRepository;

    public List<Subreddit> getAllSubreddit(){
        return subredditRepository.findAll();
    }

    public Subreddit getOne(String id){
        Optional<Subreddit> subreddit = subredditRepository.findById(id);
        if(subreddit.isPresent())
            return subreddit.get();
        else
            throw new ResourceNotFoundException("Subreddit not found for the with the Id : "+id);
    }

    public Subreddit createNewSubreddit(SubredditRequest subredditRequest) {

        if(subredditRepository.existsById(subredditRequest.getSubredditName())){
            throw new AllReadyExistsException("SubredditName: "+subredditRequest.getSubredditName()+" is already exists ");
        }

        Subreddit subreddit = new Subreddit(subredditRequest.getSubredditName(),subredditRequest.getDescription(),Instant.now()
        ,subredditRequest.getUserName());

         return subredditRepository.save(subreddit);
    }

    public void saveSubreddit(Subreddit s){
         subredditRepository.save(s);
    }

    public Subreddit getOneSubreddit(String SubredditName) {
        Optional<Subreddit> subreddit = subredditRepository.findById(SubredditName);
        if(subreddit.isPresent())
            return subreddit.get();
        else
            throw new ResourceNotFoundException("Subreddit not found for the with the Name : "+SubredditName);

    }
}
