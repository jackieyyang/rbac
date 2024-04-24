package com.jackieyang.rbac.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionVO {
    private Long id;
    private Long roleId;
    private String roleName;
    private String roleDesc;
    private List<PermissionVO> permissions;
}
