package com.devemre.jwtsecurity.service;

import com.devemre.jwtsecurity.controller.request.RoleAddRequest;
import com.devemre.jwtsecurity.entity.Role;
import com.devemre.jwtsecurity.entity.User;
import com.devemre.jwtsecurity.exception.RoleNotFoundException;
import com.devemre.jwtsecurity.exception.UserAlreadyHasRoleException;
import com.devemre.jwtsecurity.exception.UserNotFoundException;
import com.devemre.jwtsecurity.repository.RoleRepository;
import com.devemre.jwtsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public List<User> readUsers() {
        return userRepository.findAll();
    }

    public User addRole(RoleAddRequest request) throws RoleNotFoundException, UserNotFoundException {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundException(request.getEmail()));
        Role role = roleRepository.findByName(request.getRoleName())
                .orElseThrow(() -> new RoleNotFoundException(request.getRoleName()));

        List<Role> userRoles = user.getRoles();
        if (userRoles != null && userRoles.contains(role)) {
            throw new UserAlreadyHasRoleException(user.getEmail(), role.getName());
        }

        user.addRole(role);

        roleRepository.save(role);
        User savedUser = userRepository.save(user);
        return savedUser;
    }
}
