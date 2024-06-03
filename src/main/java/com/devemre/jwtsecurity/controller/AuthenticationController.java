package com.devemre.jwtsecurity.controller;

import com.devemre.jwtsecurity.controller.request.AuthenticationRequest;
import com.devemre.jwtsecurity.controller.request.RegisterRequest;
import com.devemre.jwtsecurity.controller.response.AuthenticationResponse;
import com.devemre.jwtsecurity.exception.RoleNotFoundException;
import com.devemre.jwtsecurity.exception.UserNotFoundException;
import com.devemre.jwtsecurity.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) throws RoleNotFoundException {

        AuthenticationResponse response = authenticationService.register(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) throws UserNotFoundException {
        AuthenticationResponse response = authenticationService.authenticate(request);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthenticationResponse> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        return ResponseEntity.ok(authenticationService.refreshToken(request, response));
    }
}
