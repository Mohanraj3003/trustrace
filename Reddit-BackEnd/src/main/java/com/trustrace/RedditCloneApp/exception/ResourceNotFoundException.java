package com.trustrace.RedditCloneApp.exception;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
