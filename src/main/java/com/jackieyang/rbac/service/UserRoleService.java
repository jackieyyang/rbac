package com.jackieyang.rbac.service;

import com.jackieyang.rbac.entity.dto.UserRoleDTO;
import com.jackieyang.rbac.entity.vo.UserRoleVO;

import java.util.List;

public interface UserRoleService {

    /**
     * get all user roles
     * @return user role list
     */
    List<UserRoleVO> queryUserRole();

    /**
     * get user roles by user id
     * @param userId user id
     * @return user role
     */
    UserRoleVO queryUserRoleByUserId(Long userId);

    /**
     * add user role by user id and role id
     * @param userId user id
     * @param roleId role id
     */
    void insertUserRoleByUserIdAndRoleId(Long userId, Long roleId);

    /**
     * delete user role by user id and role id
     * @param userId user id
     * @param roleId role id
     */
    void deleteUserRoleByUserIdAndRoleId(Long userId, Long roleId);

}
