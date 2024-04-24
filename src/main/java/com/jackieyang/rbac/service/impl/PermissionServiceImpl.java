package com.jackieyang.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import com.jackieyang.rbac.entity.dto.PermissionDTO;
import com.jackieyang.rbac.entity.pojo.Permission;
import com.jackieyang.rbac.entity.vo.PermissionVO;
import com.jackieyang.rbac.mapper.PermissionMapper;
import com.jackieyang.rbac.service.PermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionMapper permissionMapper;

    @Override
    public List<PermissionVO> queryPermission() {
        List<Permission> permissions = permissionMapper.queryPermission();
        return permissions.stream().map(permission -> {
            PermissionVO permissionVO = BeanUtil.copyProperties(permission, PermissionVO.class);
            permissionVO.setAllowMethod(Convert.toList(String.class, permission.getAllowMethod()));
            return permissionVO;
        }).toList();
    }

    @Override
    public void insertPermission(PermissionDTO permissionDTO) {
        Permission permission = BeanUtil.copyProperties(permissionDTO, Permission.class);
        permission.setAllowMethod(permissionDTO.getAllowMethod().toString());
        permissionMapper.insertPermission(permission);
    }

    @Override
    public void updatePermission(PermissionDTO permissionDTO) {
        Permission permission = BeanUtil.copyProperties(permissionDTO, Permission.class);
        permission.setAllowMethod(permissionDTO.getAllowMethod().toString());
        permissionMapper.updatePermission(permission);
    }

    @Override
    public void deletePermissionById(Long permissionId) {
        permissionMapper.deletePermission(permissionId);
    }

}
