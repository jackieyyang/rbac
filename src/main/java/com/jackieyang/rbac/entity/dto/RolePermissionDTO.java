package com.jackieyang.rbac.entity.dto;

import com.jackieyang.rbac.entity.vo.PermissionVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionDTO {
    private Long id;
    private Long roleId;
    private String roleName;
    private String roleDesc;
    private List<PermissionVO> permissions;
}
