package com.devemre.jwtsecurity.service;

import com.devemre.jwtsecurity.controller.request.AuthorityAddRequest;
import com.devemre.jwtsecurity.controller.request.RoleRequest;
import com.devemre.jwtsecurity.entity.Authority;
import com.devemre.jwtsecurity.entity.Role;
import com.devemre.jwtsecurity.exception.RoleAlreadyExistsException;
import com.devemre.jwtsecurity.exception.RoleAlreadyHasAuthorityException;
import com.devemre.jwtsecurity.exception.RoleNotFoundException;
import com.devemre.jwtsecurity.repository.AuthorityRepository;
import com.devemre.jwtsecurity.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;

    public Role createRole(RoleRequest request) throws RoleNotFoundException {
        if (roleRepository.findByName(request.getName()).isPresent()) {
            throw new RoleAlreadyExistsException(request.getName());
        }

        Role role = roleRepository.save(Role.builder().name(request.getName().toUpperCase()).build());

        addAuthority(AuthorityAddRequest.builder().authorityName("ROLE_" + request.getName()).roleName(request.getName()).build());

        return role;
    }

    public List<Role> readRoles() {
        return roleRepository.findAll();
    }

    public Role addAuthority(AuthorityAddRequest request) throws RoleNotFoundException {
        Role role = roleRepository.findByName(request.getRoleName())
                .orElseThrow(() -> new RoleNotFoundException(request.getRoleName()));
        Authority authority = authorityRepository.findByName(request.getAuthorityName())
                .orElse(Authority.builder()
                        .name(request.getAuthorityName())
                        .build());

        if (role.getAuthorities() != null && role.getAuthorities().contains(authority)) {
            throw new RoleAlreadyHasAuthorityException(role.getName(), authority.getName());
        }

        role.addAuthority(authority);

        authorityRepository.save(authority);
        Role savedRole = roleRepository.save(role);
        return savedRole;
    }
}
