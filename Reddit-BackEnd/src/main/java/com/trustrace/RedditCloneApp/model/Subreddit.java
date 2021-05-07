package com.trustrace.RedditCloneApp.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@Document(collection = "subreddit")
public class Subreddit {

    @Id
    private String subredditName;
    private String description;
    private ArrayList<String> postId= new ArrayList<>();
    private Instant createdAt;
    private String userName;

    public Subreddit(String subredditName, String description, Instant createdAt, String userName) {
        this.subredditName = subredditName;
        this.description = description;
        this.createdAt = createdAt;
        this.userName= userName;
    }

    public void setPostId(String postId) {
        this.postId.add(postId);
    }
}
