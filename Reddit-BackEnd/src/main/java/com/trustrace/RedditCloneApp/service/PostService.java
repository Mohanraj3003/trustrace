package com.trustrace.RedditCloneApp.service;

import com.trustrace.RedditCloneApp.dto.PostRequest;
import com.trustrace.RedditCloneApp.exception.ResourceNotFoundException;
import com.trustrace.RedditCloneApp.model.Post;
import com.trustrace.RedditCloneApp.model.Subreddit;
import com.trustrace.RedditCloneApp.model.User;
import com.trustrace.RedditCloneApp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;


    @Autowired
    UserService userService;


    @Autowired
    SubredditService subredditService;


    public List getAllPosts() {
       return postRepository.findAll();
    }

    @Transactional
    public Post createNewPost(PostRequest postRequest) {

        Post post = new Post(postRequest.getPostName(),postRequest.getUrl(),postRequest.getDescription(),Instant.now(),
                postRequest.getSubredditId(),postRequest.getUserName());
       Post response =  postRepository.save(post);

        User user = userService.getOneUser(post.getUserName());
        user.setPosts(response.getId());
        userService.saveUser(user);

        Subreddit subreddit = subredditService.getOne(postRequest.getSubredditId());
        subreddit.setPostId(response.getId());
        subredditService.saveSubreddit(subreddit);

        return response;

    }

    public Post getOnePost(String id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isPresent())
            return post.get();
        else
            throw new ResourceNotFoundException("Post not found for the with the Id : "+id);
    }

    public Post savePost(Post post){
        return postRepository.save(post);
    }

}
