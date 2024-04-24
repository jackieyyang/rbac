package com.jackieyang.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.jackieyang.rbac.entity.pojo.RolePermission;
import com.jackieyang.rbac.entity.vo.PermissionVO;
import com.jackieyang.rbac.entity.vo.RolePermissionVO;
import com.jackieyang.rbac.mapper.RolePermissionMapper;
import com.jackieyang.rbac.service.RolePermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionMapper rolePermissionMapper;

    @Override
    public List<RolePermissionVO> queryRolePermissions() {
        List<RolePermission> rolePermissions = rolePermissionMapper.queryRolePermissions();
        Map<Long, List<RolePermission>> collectMap = rolePermissions.stream()
                .collect(Collectors.groupingBy(RolePermission::getRoleId));
        return collectMap.values().stream()
                .map(this::getRolePermissionVO)
                .collect(Collectors.toList());
    }

    @Override
    public RolePermissionVO queryRolePermissionByRoleId(Long roleId) {
        List<RolePermission> rolePermissions = rolePermissionMapper.queryRolePermissionByRoleId(roleId);
        return getRolePermissionVO(rolePermissions);
    }

    @Override
    public void insertRolePermissionByRoleIdAndPermissionId(Long roleId, Long permissionId) {
        rolePermissionMapper.insertRolePermissionByRoleIdAndPermissionId(roleId, permissionId);
    }

    @Override
    public void deleteRolePermissionByRoleIdAndPermissionId(Long roleId, Long permissionId) {
        rolePermissionMapper.deleteRolePermissionByRoleIdAndPermissionId(roleId, permissionId);
    }

    private RolePermissionVO getRolePermissionVO(List<RolePermission> rolePermissions) {
        RolePermissionVO rolePermissionVO = BeanUtil.copyProperties(rolePermissions.get(0), RolePermissionVO.class);
        List<PermissionVO> permissionVOList = rolePermissions.stream()
                .map(permission -> {
                    PermissionVO permissionVO = BeanUtil.copyProperties(permission, PermissionVO.class);
                    permissionVO.setId(permission.getPermissionId());
                    return permissionVO;
                }).toList();
        rolePermissionVO.setPermissions(permissionVOList);
        return rolePermissionVO;
    }
}
