package com.jackieyang.rbac.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRolePermission {
    private Long userId;
    private String username;
    private Long roleId;
    private String roleName;
    private String roleDesc;
    private Long permissionId;
    private String allowPath;
    private String allowMethod;
    private String permissionDesc;
}
