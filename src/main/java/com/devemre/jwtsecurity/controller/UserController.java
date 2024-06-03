package com.devemre.jwtsecurity.controller;

import com.devemre.jwtsecurity.controller.request.RoleAddRequest;
import com.devemre.jwtsecurity.entity.User;
import com.devemre.jwtsecurity.exception.RoleNotFoundException;
import com.devemre.jwtsecurity.exception.UserNotFoundException;
import com.devemre.jwtsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.readUsers());
    }

    @PostMapping("/add-role")
    public ResponseEntity<String> addRole(@RequestBody RoleAddRequest request) throws UserNotFoundException, RoleNotFoundException {
        User user = userService.addRole(request);

        return ResponseEntity.ok("Role " + request.getRoleName() + " is successfully added to user " + user.getEmail() + ".");
    }
}
