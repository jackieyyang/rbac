package com.jackieyang.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import com.jackieyang.rbac.entity.pojo.Permission;
import com.jackieyang.rbac.entity.pojo.UserRolePermission;
import com.jackieyang.rbac.entity.vo.PermissionVO;
import com.jackieyang.rbac.entity.vo.RoleVO;
import com.jackieyang.rbac.entity.vo.UserRolePermissionVO;
import com.jackieyang.rbac.exception.ForbiddenException;
import com.jackieyang.rbac.mapper.RbacMapper;
import com.jackieyang.rbac.service.RbacService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RbacServiceImpl implements RbacService {

    private final RbacMapper rbacMapper;

    @Override
    public void authorization(String path, String method, UserRolePermissionVO userRolePermissionVO) {
        // judge whether the user could access the path
        List<PermissionVO> permissions = userRolePermissionVO.getPermissions();
        permissions.stream().filter(permission -> new AntPathMatcher().match(permission.getAllowPath(), path))
                .findFirst()
                .orElseThrow(() -> new ForbiddenException("Path denied"));
        // judge whether the user could access the method
        permissions.stream().filter(permission -> new AntPathMatcher().match(permission.getAllowPath(), path))
                .filter(permission -> permission.getAllowMethod().contains(method))
                .findFirst()
                .orElseThrow(() -> new ForbiddenException("Method denied"));
    }

    @Override
    public UserRolePermissionVO queryUserRolePermission(Long userId) {
        List<UserRolePermission> userRolePermissions = rbacMapper.queryUserRolePermissionByUserId(userId);
        // set user info
        UserRolePermissionVO userRolePermissionVO = BeanUtil.copyProperties(userRolePermissions.get(0), UserRolePermissionVO.class);
        // set roles
        List<RoleVO> roles = userRolePermissions.stream()
                .map(userRolePermission -> {
                    RoleVO roleVO = BeanUtil.copyProperties(userRolePermission, RoleVO.class);
                    roleVO.setId(userRolePermission.getRoleId());
                    return roleVO;
                }).distinct().toList();
        userRolePermissionVO.setRoles(roles);
        // set permissions
        List<PermissionVO> permissions = userRolePermissions.stream()
                .map(userRolePermission -> {
                    Permission permission = BeanUtil.copyProperties(userRolePermission, Permission.class);
                    permission.setId(userRolePermission.getPermissionId());
                    PermissionVO permissionVO = BeanUtil.copyProperties(permission, PermissionVO.class);
                    permissionVO.setAllowMethod(Convert.toList(String.class, permission.getAllowMethod()));
                    return permissionVO;
                }).distinct().toList();
        userRolePermissionVO.setPermissions(permissions);
        return userRolePermissionVO;
    }
}
