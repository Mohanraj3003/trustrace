package com.trustrace.RedditCloneApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "votes")
public class Vote {

    @Id
    private String id;
    private String userName;
    private String voteType;
    private String postId;

    public Vote(String userName, String voteType, String postId) {
        this.userName = userName;
        this.voteType = voteType;
        this.postId = postId;
    }
}
