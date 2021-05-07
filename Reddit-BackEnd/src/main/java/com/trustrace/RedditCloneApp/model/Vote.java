package com.trustrace.RedditCloneApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "votes")
public class Vote {

    @Id
    private String userName;
    private String voteType;
    private String postId;

}
