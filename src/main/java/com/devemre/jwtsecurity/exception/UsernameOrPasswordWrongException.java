package com.devemre.jwtsecurity.exception;

public class UsernameOrPasswordWrongException extends RuntimeException {

    public UsernameOrPasswordWrongException() {
        super("Username or password are wrong!");
    }
}
