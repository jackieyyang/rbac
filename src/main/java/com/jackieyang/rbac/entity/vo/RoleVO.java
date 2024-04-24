package com.jackieyang.rbac.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVO {
    private Long id;
    private String roleName;
    private String roleDesc;
}
