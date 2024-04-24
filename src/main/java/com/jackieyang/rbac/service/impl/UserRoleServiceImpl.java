package com.jackieyang.rbac.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.jackieyang.rbac.entity.pojo.UserRole;
import com.jackieyang.rbac.entity.vo.RoleVO;
import com.jackieyang.rbac.entity.vo.UserRoleVO;
import com.jackieyang.rbac.mapper.UserRoleMapper;
import com.jackieyang.rbac.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleMapper userRoleMapper;

    @Override
    public List<UserRoleVO> queryUserRole() {
        List<UserRole> userRoles = userRoleMapper.queryUserRoles();
        Map<Long, List<UserRole>> collectMap = userRoles.stream()
                .collect(Collectors.groupingBy(UserRole::getUserId));
        return collectMap.values().stream()
                .map(this::getUserRoleVO)
                .collect(Collectors.toList());
    }

    @Override
    public UserRoleVO queryUserRoleByUserId(Long userId) {
        List<UserRole> userRoles = userRoleMapper.queryUserRoleByUserId(userId);
        return getUserRoleVO(userRoles);
    }

    @Override
    public void insertUserRoleByUserIdAndRoleId(Long userId, Long roleId) {
        userRoleMapper.insertUserRoleByUserIdAndRoleId(userId, roleId);
    }

    @Override
    public void deleteUserRoleByUserIdAndRoleId(Long userId, Long roleId) {
        userRoleMapper.deleteUserRoleByUserIdAndRoleId(userId, roleId);
    }

    private UserRoleVO getUserRoleVO(List<UserRole> userRoles) {
        UserRoleVO userRoleVO = BeanUtil.copyProperties(userRoles.get(0), UserRoleVO.class);
        List<RoleVO> roleVOList = userRoles.stream()
                .map(role -> {
                    RoleVO roleVO = BeanUtil.copyProperties(role, RoleVO.class);
                    roleVO.setId(role.getRoleId());
                    return roleVO;
                }).toList();
        userRoleVO.setRoles(roleVOList);
        return userRoleVO;
    }

}
