package com.devemre.jwtsecurity.controller;

import com.devemre.jwtsecurity.controller.request.AuthorityAddRequest;
import com.devemre.jwtsecurity.controller.request.RoleRequest;
import com.devemre.jwtsecurity.entity.Authority;
import com.devemre.jwtsecurity.entity.Role;
import com.devemre.jwtsecurity.exception.RoleNotFoundException;
import com.devemre.jwtsecurity.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getRoles() {
        return ResponseEntity.ok(roleService.readRoles());
    }

    @PostMapping
    public ResponseEntity<String> createRole(@RequestBody RoleRequest request) throws RoleNotFoundException {
        Role role = roleService.createRole(request);

        return ResponseEntity.ok("Role Name: " + role.getName() + ", Role Id: " + role.getId() + " is successfully created.");
    }

    @PostMapping("/add-authority")
    public ResponseEntity<String> addAuthority(@RequestBody AuthorityAddRequest request) throws RoleNotFoundException {
        Role role = roleService.addAuthority(request);

        return ResponseEntity.ok("Authority Name: " + request.getAuthorityName() + " is successfully added to role " + role.getName() + ".");
    }
}
