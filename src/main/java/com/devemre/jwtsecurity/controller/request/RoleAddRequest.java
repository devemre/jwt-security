package com.devemre.jwtsecurity.controller.request;

import com.devemre.jwtsecurity.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleAddRequest {

    String roleName;
    String email;
}
