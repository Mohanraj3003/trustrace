package com.trustrace.RedditCloneApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private String userName;
    private String text;
    private Instant createdAt;

}
