package com.devemre.jwtsecurity.controller;

import com.devemre.jwtsecurity.controller.request.AuthorityAddRequest;
import com.devemre.jwtsecurity.controller.request.RegisterRequest;
import com.devemre.jwtsecurity.controller.request.RoleRequest;
import com.devemre.jwtsecurity.entity.Role;
import com.devemre.jwtsecurity.exception.RoleNotFoundException;
import com.devemre.jwtsecurity.service.AuthenticationService;
import com.devemre.jwtsecurity.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
@RequiredArgsConstructor
public class DemoController {

    private final RoleService roleService;
    private final AuthenticationService authenticationService;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @GetMapping("/set-initial")
    public ResponseEntity<String> setInitialData() throws RoleNotFoundException {
        roleService.createRole(RoleRequest.builder().name("ADMIN").build());
        roleService.createRole(RoleRequest.builder().name("MANAGER").build());
        roleService.createRole(RoleRequest.builder().name("USER").build());

        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("admin_create").roleName("ADMIN").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("admin_read").roleName("ADMIN").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("admin_update").roleName("ADMIN").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("admin_delete").roleName("ADMIN").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("manager_create").roleName("ADMIN").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("manager_read").roleName("ADMIN").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("manager_update").roleName("ADMIN").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("manager_delete").roleName("ADMIN").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("user_create").roleName("ADMIN").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("user_read").roleName("ADMIN").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("user_update").roleName("ADMIN").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("user_delete").roleName("ADMIN").build());

        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("manager_create").roleName("MANAGER").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("manager_read").roleName("MANAGER").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("manager_update").roleName("MANAGER").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("manager_delete").roleName("MANAGER").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("user_create").roleName("MANAGER").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("user_read").roleName("MANAGER").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("user_update").roleName("MANAGER").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("user_delete").roleName("MANAGER").build());

        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("user_create").roleName("USER").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("user_read").roleName("USER").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("user_update").roleName("USER").build());
        roleService.addAuthority(AuthorityAddRequest.builder().authorityName("user_delete").roleName("USER").build());

        authenticationService.register(RegisterRequest.builder().email("admin@example.com").firstName("admin").lastName("account").password("12345").roleName("ADMIN").build());
        authenticationService.register(RegisterRequest.builder().email("manager@example.com").firstName("manager").lastName("account").password("12345").roleName("MANAGER").build());
        authenticationService.register(RegisterRequest.builder().email("user@example.com").firstName("user").lastName("account").password("12345").roleName("USER").build());

        return ResponseEntity.ok("Initial Data is created for tests");
    }
}
