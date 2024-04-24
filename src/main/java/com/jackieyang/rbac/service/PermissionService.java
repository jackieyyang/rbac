package com.jackieyang.rbac.service;

import com.jackieyang.rbac.entity.dto.PermissionDTO;
import com.jackieyang.rbac.entity.vo.PermissionVO;

import java.util.List;

public interface PermissionService {

    /**
     * query all permissions
     * @return List<PermissionVO>
     */
    List<PermissionVO> queryPermission();

    /**
     * insert new permission
     * @param permissionDTO permissionDTO
     */
    void insertPermission(PermissionDTO permissionDTO);

    /**
     * update permission by id
     * @param permissionDTO permissionDTO
     */
    void updatePermission(PermissionDTO permissionDTO);

    /**
     * delete permission by id
     * @param permissionId permissionId
     */
    void deletePermissionById(Long permissionId);
}
