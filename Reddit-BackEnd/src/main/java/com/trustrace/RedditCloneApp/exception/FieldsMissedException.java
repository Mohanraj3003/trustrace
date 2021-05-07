package com.trustrace.RedditCloneApp.exception;

public class FieldsMissedException extends  RuntimeException{

    public FieldsMissedException(String msg) {
        super(msg);
    }
}
