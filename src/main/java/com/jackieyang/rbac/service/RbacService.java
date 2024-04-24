package com.jackieyang.rbac.service;

import com.jackieyang.rbac.entity.vo.UserRolePermissionVO;

public interface RbacService {

    /**
     * Check if the user has the permission to access the path
     * if not, throw a forbidden exception
     * @param path request path
     * @param method http method
     * @param userRolePermissionVO user role permission
     */
    public void authorization(String path, String method, UserRolePermissionVO userRolePermissionVO);

    /**
     * Query user role permission
     * @param userId user id
     * @return user role permission
     */
    public UserRolePermissionVO queryUserRolePermission(Long userId);

}
