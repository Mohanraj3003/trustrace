package com.trustrace.RedditCloneApp.repository;

import com.trustrace.RedditCloneApp.model.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VoteRepository extends MongoRepository<Vote,String> {


    boolean existsByPostId(String postId);

    boolean existsByUserName(String userName);

    List findAllByUserName(String user);

    Vote findAllByUserNameAndPostId(String userName, String postId);
}
