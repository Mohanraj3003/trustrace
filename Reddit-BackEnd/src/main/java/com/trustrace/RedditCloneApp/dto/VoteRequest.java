package com.trustrace.RedditCloneApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteRequest {

    private String voteType;
    private String postId;
    private String userName;

}
