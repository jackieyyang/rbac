package com.jackieyang.rbac.controller;

import com.jackieyang.rbac.entity.dto.PermissionDTO;
import com.jackieyang.rbac.entity.pojo.ResponseEntity;
import com.jackieyang.rbac.entity.vo.PermissionVO;
import com.jackieyang.rbac.service.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rbac")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    /**
     * get all permissions
     * @return response entity with permission list
     */
    @GetMapping("/permission")
    public ResponseEntity<List<PermissionVO>> getPermission() {
        List<PermissionVO> permissions = permissionService.queryPermission();
        return ResponseEntity.success(permissions);
    }

    /**
     * add permission
     * @param permissionDTO permissionDTO
     * @return response entity
     */
    @PostMapping("/permission")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> addPermission(@RequestBody PermissionDTO permissionDTO) {
        permissionService.insertPermission(permissionDTO);
        return ResponseEntity.created();
    }

    /**
     * update permission
     * @param permissionDTO permissionDTO
     * @return response entity
     */
    @PutMapping("/permission")
    public ResponseEntity<Object> updatePermission(@RequestBody PermissionDTO permissionDTO) {
        permissionService.updatePermission(permissionDTO);
        return ResponseEntity.success();
    }

    /**
     * delete permission
     * @param permissionId permissionId
     * @return response entity
     */
    @DeleteMapping("/permission/{permissionId}")
    public ResponseEntity<Object> deletePermission(@PathVariable Long permissionId) {
        permissionService.deletePermissionById(permissionId);
        return ResponseEntity.success();
    }

}
