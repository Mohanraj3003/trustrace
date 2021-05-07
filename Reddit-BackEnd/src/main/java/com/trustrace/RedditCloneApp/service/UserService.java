package com.trustrace.RedditCloneApp.service;

import com.trustrace.RedditCloneApp.exception.ResourceNotFoundException;
import com.trustrace.RedditCloneApp.model.User;
import com.trustrace.RedditCloneApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getAllUsers(){
         return userRepository.findAll();
    }

    public User getOneUser(String userName){
         Optional<User> user = userRepository.findById(userName);
         if(user.isPresent())
             return user.get();
         else
             throw new ResourceNotFoundException("User not found for the with the UserName : "+userName);
    }

    
    public void saveUser(User user){
       userRepository.save(user);
    }
    



}
