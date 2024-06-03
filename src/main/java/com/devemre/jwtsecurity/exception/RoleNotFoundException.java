package com.devemre.jwtsecurity.exception;

public class RoleNotFoundException extends Exception {

    public RoleNotFoundException(String roleName) {
        super("Role with name " + roleName + " not found!");
    }
}
