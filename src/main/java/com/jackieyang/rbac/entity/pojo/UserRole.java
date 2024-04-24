package com.jackieyang.rbac.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    private Long id;
    private Long userId;
    private String username;
    private List<Role> roles;
}
