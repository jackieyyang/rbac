package com.jackieyang.rbac.entity.vo;

import com.jackieyang.rbac.entity.pojo.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleVO {
    private Long id;
    private Long userId;
    private String username;
    private List<Role> roles;
}
