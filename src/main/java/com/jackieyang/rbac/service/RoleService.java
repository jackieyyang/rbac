package com.jackieyang.rbac.service;

import com.jackieyang.rbac.entity.dto.RoleDTO;
import com.jackieyang.rbac.entity.vo.RoleVO;

import java.util.List;

public interface RoleService {

    /**
     * query all roles
     * @return role list
     */
    List<RoleVO> queryRoles();

    /**
     * add role
     * @param roleDTO roleDTO
     */
    void insertRole(RoleDTO roleDTO);

    /**
     * update role by id
     * @param roleDTO roleDTO
     */
    void updateRole(RoleDTO roleDTO);

    /**
     * delete role by id
     * @param roleId roleId
     */
    void deleteRoleById(Long roleId);

}
