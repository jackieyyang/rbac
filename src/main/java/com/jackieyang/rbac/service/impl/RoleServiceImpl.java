package com.jackieyang.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.jackieyang.rbac.entity.dto.RoleDTO;
import com.jackieyang.rbac.entity.pojo.Role;
import com.jackieyang.rbac.entity.vo.RoleVO;
import com.jackieyang.rbac.mapper.RoleMapper;
import com.jackieyang.rbac.mapper.RolePermissionMapper;
import com.jackieyang.rbac.mapper.UserRoleMapper;
import com.jackieyang.rbac.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    private final RolePermissionMapper rolePermissionMapper;

    private final UserRoleMapper userRoleMapper;

    @Override
    public List<RoleVO> queryRoles() {
        List<Role> roles = roleMapper.queryRoles();
        return BeanUtil.copyToList(roles, RoleVO.class);
    }

    @Override
    public void insertRole(RoleDTO roleDTO) {
        Role role = BeanUtil.copyProperties(roleDTO, Role.class);
        roleMapper.insertRole(role);
    }

    @Override
    public void updateRole(RoleDTO roleDTO) {
        Role role = BeanUtil.copyProperties(roleDTO, Role.class);
        roleMapper.updateRoleById(role);
    }

    @Override
    public void deleteRoleById(Long roleId) {
        // delete role table by roleId
        roleMapper.deleteRoleById(roleId);
        // delete user_role table by roleId
        userRoleMapper.deleteUserRoleByRoleId(roleId);
        // delete role_permission table by roleId
        rolePermissionMapper.deleteRolePermissionByRoleId(roleId);
    }

}
