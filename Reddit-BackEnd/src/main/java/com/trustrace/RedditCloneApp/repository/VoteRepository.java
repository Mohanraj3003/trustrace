package com.trustrace.RedditCloneApp.repository;

import com.trustrace.RedditCloneApp.model.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VoteRepository extends MongoRepository<Vote,String> {


}
