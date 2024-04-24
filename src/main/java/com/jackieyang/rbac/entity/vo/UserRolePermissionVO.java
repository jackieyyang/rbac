package com.jackieyang.rbac.entity.vo;

import com.jackieyang.rbac.entity.vo.PermissionVO;
import com.jackieyang.rbac.entity.vo.RoleVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRolePermissionVO {
    private Long userId;
    private String username;
    private List<RoleVO> roles;
    private List<PermissionVO> permissions;
}
