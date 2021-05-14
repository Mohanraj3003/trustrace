package com.trustrace.RedditCloneApp.service;

import com.trustrace.RedditCloneApp.dto.CommentRequest;
import com.trustrace.RedditCloneApp.model.Comment;
import com.trustrace.RedditCloneApp.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CommentService {

    @Autowired
    PostService postService;

    public Post newComment(String postid, CommentRequest comments) {

        Post post = postService.getOnePost(postid);

        Comment comment = new Comment(comments.getUserName(),comments.getComment(), Instant.now());

        post.setComments(comment);

        return postService.savePost(post);

    }
}
