package com.trustrace.RedditCloneApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubredditRequest {

    private String subredditName;
    private String description;
    private String userName;
}
