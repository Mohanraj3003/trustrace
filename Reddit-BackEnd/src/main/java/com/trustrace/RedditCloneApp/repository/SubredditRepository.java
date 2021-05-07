package com.trustrace.RedditCloneApp.repository;

import com.trustrace.RedditCloneApp.model.Subreddit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("subreddit")
public interface SubredditRepository extends MongoRepository<Subreddit,String> {

//    boolean existsBySubredditName(String subredditName);
}
