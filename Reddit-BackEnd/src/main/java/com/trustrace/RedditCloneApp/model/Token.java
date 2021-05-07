package com.trustrace.RedditCloneApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "token")
public class Token {

    @Id
    private String id;

    private String token;

    private LocalDateTime createdAt;

    private LocalDateTime expiresAt;

    private User userName;

    public Token(String token,
                      LocalDateTime createdAt,
                      LocalDateTime expiresAt,
                      User userName) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.userName = userName;
    }
}
