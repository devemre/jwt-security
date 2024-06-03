package com.devemre.jwtsecurity.exception;

public class RoleAlreadyExistsException extends RuntimeException {

    public RoleAlreadyExistsException(String roleName) {
        super("Role " + roleName + " already exists!");
    }
}
