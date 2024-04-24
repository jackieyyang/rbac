package com.jackieyang.rbac.controller;

import com.jackieyang.rbac.entity.dto.RoleDTO;
import com.jackieyang.rbac.entity.pojo.ResponseEntity;
import com.jackieyang.rbac.entity.vo.RoleVO;
import com.jackieyang.rbac.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rbac")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    /**
     * get all roles
     * @return response entity with role list
     */
    @GetMapping("/role")
    public ResponseEntity<List<RoleVO>> getRole() {
        List<RoleVO> roles = roleService.queryRoles();
        return ResponseEntity.success(roles);
    }

    /**
     * add role
     * @param roleDTO roleDTO
     * @return response entity
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/role")
    public ResponseEntity<Object> addRole(@RequestBody RoleDTO roleDTO) {
        roleService.insertRole(roleDTO);
        return ResponseEntity.created();
    }

    /**
     * update role
     * @param roleDTO roleDTO
     * @return response entity
     */
    @PutMapping("/role")
    public ResponseEntity<Object> updateRole(@RequestBody RoleDTO roleDTO) {
        roleService.updateRole(roleDTO);
        return ResponseEntity.success();
    }

    /**
     * delete role
     * @param roleId roleId
     * @return response entity
     */
    @DeleteMapping("/role/{roleId}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long roleId) {
        roleService.deleteRoleById(roleId);
        return ResponseEntity.success();
    }
}
