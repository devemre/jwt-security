package com.devemre.jwtsecurity.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String email) {
        super("User with " + email + " not found!");
    }
}
