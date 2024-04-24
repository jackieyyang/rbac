package com.jackieyang.rbac.service.impl;

import com.jackieyang.rbac.entity.vo.UserRolePermissionVO;
import com.jackieyang.rbac.exception.ForbiddenException;
import com.jackieyang.rbac.service.RbacService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.AntPathMatcher;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RbacServiceImplTest {

    @Autowired
    private RbacService rbacService;

    @Test
    void authorization() {
        UserRolePermissionVO userRolePermissionVO = rbacService.queryUserRolePermission(2L);
        try {
            rbacService.authorization("/user", "POST", userRolePermissionVO);
        } catch (ForbiddenException e) {
            Assertions.assertEquals("Path denied", e.getMessage());
        }
        try {
            rbacService.authorization("/rbac/role", "DELETE", userRolePermissionVO);
        } catch (ForbiddenException e) {
            Assertions.assertEquals("Method denied", e.getMessage());
        }
    }

    @Test
    void queryUserRolePermission() {
        System.out.println(rbacService.queryUserRolePermission(2L));
    }

    @Test
    void testPath() {
        System.out.println(new AntPathMatcher().match("/rbac/user/*/role/*", "/rbac/user/2/role"));
    }
}