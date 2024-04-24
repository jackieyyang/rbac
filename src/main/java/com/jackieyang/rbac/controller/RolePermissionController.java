package com.jackieyang.rbac.controller;

import com.jackieyang.rbac.entity.pojo.ResponseEntity;
import com.jackieyang.rbac.entity.vo.RolePermissionVO;
import com.jackieyang.rbac.service.RolePermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rbac")
@RequiredArgsConstructor
public class RolePermissionController {

    private final RolePermissionService rolePermissionService;

    /**
     * get all role permissions
     * @return response entity with role permission list
     */
    @GetMapping("/role/permission")
    public ResponseEntity<List<RolePermissionVO>> getRolePermission() {
        List<RolePermissionVO> rolePermissions = rolePermissionService.queryRolePermissions();
        return ResponseEntity.success(rolePermissions);
    }

    /**
     * get role permissions by role id
     * @return response entity with role permission list
     */
    @GetMapping("/role/{roleId}/permission")
    public ResponseEntity<RolePermissionVO> getRolePermissionByRoleId(@PathVariable Long roleId) {
        RolePermissionVO rolePermissionVO = rolePermissionService.queryRolePermissionByRoleId(roleId);
        return ResponseEntity.success(rolePermissionVO);
    }

    /**
     * add role permission - by role id and permission id
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/role/{roleId}/permission/{permissionId}")
    public ResponseEntity<Object> addRolePermissionByPermissionId(@PathVariable Long roleId, @PathVariable Long permissionId) {
        rolePermissionService.insertRolePermissionByRoleIdAndPermissionId(roleId, permissionId);
        return ResponseEntity.created();
    }

    /**
     * delete role permission - by role id and permission id
     */
    @DeleteMapping("/role/{roleId}/permission/{permissionId}")
    public ResponseEntity<Object> deleteRolePermissionByPermissionId(@PathVariable Long roleId, @PathVariable Long permissionId) {
        rolePermissionService.deleteRolePermissionByRoleIdAndPermissionId(roleId, permissionId);
        return ResponseEntity.success();
    }

}
