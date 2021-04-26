package com.example.Spring.Rest.repository;

import com.example.Spring.Rest.Model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {
}
