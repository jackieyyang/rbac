package com.jackieyang.rbac.service;

import com.jackieyang.rbac.entity.vo.RolePermissionVO;

import java.util.List;

public interface RolePermissionService {


    /**
     * query all role permissions
     * @return role permission list
     */
    List<RolePermissionVO> queryRolePermissions();

    /**
     * delete role permission by role id
     * @param roleId roleId
     * @return role permission
     */
    RolePermissionVO queryRolePermissionByRoleId(Long roleId);

    /**
     * delete role permission by role id
     * @param roleId roleId
     * @param permissionId permissionId
     */
    void insertRolePermissionByRoleIdAndPermissionId(Long roleId, Long permissionId);

    /**
     * delete role permission by role id and permission id
     * @param roleId roleId
     * @param permissionId permissionId
     */
    void deleteRolePermissionByRoleIdAndPermissionId(Long roleId, Long permissionId);

}
