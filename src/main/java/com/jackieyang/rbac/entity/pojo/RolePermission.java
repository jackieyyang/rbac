package com.jackieyang.rbac.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermission {
    private Long id;
    private Long roleId;
    private Long permissionId;
    private String roleName;
    private String roleDesc;
    private String allowPath;
    private String allowMethod;
    private String permissionDesc;
}
