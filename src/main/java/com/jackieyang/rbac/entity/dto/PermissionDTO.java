package com.jackieyang.rbac.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDTO {
    private Long id;
    private String allowPath;
    private List<String> allowMethod;
    private String permissionDesc;
}
