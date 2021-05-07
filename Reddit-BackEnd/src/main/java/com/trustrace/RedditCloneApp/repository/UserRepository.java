package com.trustrace.RedditCloneApp.repository;

import com.trustrace.RedditCloneApp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

      Boolean existsByMail(String mail);


      Optional<User> findByUserName(String s);
}
