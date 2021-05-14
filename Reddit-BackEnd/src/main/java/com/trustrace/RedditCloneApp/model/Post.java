package com.trustrace.RedditCloneApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@Document(collection = "posts")
public class Post {

    @Id
    private String id;
    private String postName;
    private String url;
    private String description;
    private Integer voteCount = 0;
    private Instant createdAt;
    private String subredditId;
    private String userName;
    private ArrayList<Comment> comments= new ArrayList<>();

    public Post(String postName,
                String url, String description, Instant createdAt,
                String subredditId, String userName) {
        this.postName = postName;
        this.url = url;
        this.description = description;
        this.createdAt = createdAt;
        this.subredditId = subredditId;
        this.userName = userName;
    }

    public void setComments(Comment comment) {
        comments.add(comment);
    }

}
