package com.example.Spring.Rest.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserPatch {

   private String action;
   private String path;
   private String value;

}
