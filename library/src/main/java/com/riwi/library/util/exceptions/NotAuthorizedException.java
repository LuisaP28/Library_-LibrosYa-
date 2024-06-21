package com.riwi.library.util.exceptions;

public class NotAuthorizedException extends RuntimeException{
    public NotAuthorizedException(String id) {
        super(id);
    }
}