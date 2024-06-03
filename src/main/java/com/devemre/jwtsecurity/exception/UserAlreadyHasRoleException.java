package com.devemre.jwtsecurity.exception;

public class UserAlreadyHasRoleException extends RuntimeException {

    public UserAlreadyHasRoleException(String email, String roleName) {
        super("User " + email + " already has " + roleName + " role!");
    }
}
