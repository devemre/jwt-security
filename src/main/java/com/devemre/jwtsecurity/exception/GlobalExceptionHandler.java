package com.devemre.jwtsecurity.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Object> handleRoleNotFoundException(RoleNotFoundException exception) {
        return ResponseEntity.status(404).body(exception.getMessage());
    }

    @ExceptionHandler(RoleAlreadyExistsException.class)
    public ResponseEntity<Object> handleRoleAlreadyExistsException(RoleAlreadyExistsException exception) {
        return ResponseEntity.status(403).body(exception.getMessage());
    }

    @ExceptionHandler(RoleAlreadyHasAuthorityException.class)
    public ResponseEntity<Object> handleRoleAlreadyHasAuthorityException(RoleAlreadyHasAuthorityException exception) {
        return ResponseEntity.status(403).body(exception.getMessage());
    }

    @ExceptionHandler(UsernameOrPasswordWrongException.class)
    public ResponseEntity<Object> handleUsernameOrPasswordWrongException(UsernameOrPasswordWrongException exception) {
        return ResponseEntity.status(404).body(exception.getMessage());
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserAlreadyExistsException(UserAlreadyExistsException exception) {
        return ResponseEntity.status(403).body(exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
        return ResponseEntity.status(404).body(exception.getMessage());
    }

    @ExceptionHandler(UserAlreadyHasRoleException.class)
    public ResponseEntity<Object> handleUserAlreadyHasRoleException(UserAlreadyHasRoleException exception) {
        return ResponseEntity.status(403).body(exception.getMessage());
    }
}
