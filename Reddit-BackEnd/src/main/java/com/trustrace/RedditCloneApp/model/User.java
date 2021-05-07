package com.trustrace.RedditCloneApp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@Document(collection = "users")
public class User {

    @Id
//    private String id;
    private String userName;
    private String name;
    private String password;
    private String mail;
    private ArrayList<String> posts= new ArrayList<String>();
    private Instant createdAt;
    private boolean isEnabled;

    public User(String userName, String name,String password, String mail, Instant created) {
        this.userName = userName;
        this.password = password;
        this.mail = mail;
        this.createdAt = created;
        this.name = name;
    }

    public Boolean setPosts(String post) {
        return posts.add(post);
    }

}
