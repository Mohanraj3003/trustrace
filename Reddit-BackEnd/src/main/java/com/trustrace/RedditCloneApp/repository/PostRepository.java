package com.trustrace.RedditCloneApp.repository;

import com.trustrace.RedditCloneApp.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

}
