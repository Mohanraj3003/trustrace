package com.trustrace.RedditCloneApp.dto;

import lombok.Getter;

@Getter
public class PostRequest {
    private String postName;
    private String url;
    private String description;
    private String subredditName;
    private String userName;
}
