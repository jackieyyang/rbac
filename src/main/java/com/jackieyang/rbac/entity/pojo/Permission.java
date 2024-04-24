package com.jackieyang.rbac.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private Long id;
    private String allowPath;
    private String allowMethod;
    private String permissionDesc;
}
