package com.jackieyang.rbac.entity.dto;

import com.jackieyang.rbac.entity.pojo.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleDTO {
    private Long id;
    private Long userId;
    private String username;
    private List<Role> roles;
}
