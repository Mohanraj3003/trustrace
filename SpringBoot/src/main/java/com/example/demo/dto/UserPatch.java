package com.example.demo.dto;


public class UserPatch {

   private String action;
   private String path;
   private String value;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UserPatch{" +
                "Action='" + action + '\'' +
                ", path='" + path + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
