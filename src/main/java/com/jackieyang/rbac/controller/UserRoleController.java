package com.jackieyang.rbac.controller;

import com.jackieyang.rbac.entity.dto.UserRoleDTO;
import com.jackieyang.rbac.entity.pojo.ResponseEntity;
import com.jackieyang.rbac.entity.vo.UserRoleVO;
import com.jackieyang.rbac.service.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rbac")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    /**
     * get all user roles
     * @return response entity with user role list
     */
    @GetMapping("/user/role")
    public ResponseEntity<List<UserRoleVO>> getUserRole() {
        List<UserRoleVO> userRoles = userRoleService.queryUserRole();
        return ResponseEntity.success(userRoles);
    }

    /**
     * get user roles by user id
     * @return response entity with user role list
     */
    @GetMapping("/user/{userId}/role")
    public ResponseEntity<UserRoleVO> getUserRoleByUserId(@PathVariable Long userId) {
        UserRoleVO userRoleVO = userRoleService.queryUserRoleByUserId(userId);
        return ResponseEntity.success(userRoleVO);
    }

    /**
     * add user role - by user id and role id
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/user/{userId}/role/{roleId}")
    public ResponseEntity<Object> addUserRoleByRoleId(@PathVariable Long userId, @PathVariable Long roleId) {
        userRoleService.insertUserRoleByUserIdAndRoleId(userId, roleId);
        return ResponseEntity.created();
    }

    /**
     * delete user role - by user id and role id
     */
    @DeleteMapping("/user/{userId}/role/{roleId}")
    public ResponseEntity<Object> deleteUserRoleByRoleId(@PathVariable Long userId, @PathVariable Long roleId) {
        userRoleService.deleteUserRoleByUserIdAndRoleId(userId, roleId);
        return ResponseEntity.success();
    }

}
