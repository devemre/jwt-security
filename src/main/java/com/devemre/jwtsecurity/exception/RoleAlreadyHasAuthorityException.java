package com.devemre.jwtsecurity.exception;

public class RoleAlreadyHasAuthorityException extends RuntimeException {

    public RoleAlreadyHasAuthorityException(String roleName, String authorityName) {
        super(roleName + " already has " + authorityName + " authority!");
    }
}
