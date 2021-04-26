package com.example.Spring.Rest.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "user")
public class UserModel {

    @Id
    private String id;

    private String name;
    private String address;
    private String mailId;
    private String phone;

}
