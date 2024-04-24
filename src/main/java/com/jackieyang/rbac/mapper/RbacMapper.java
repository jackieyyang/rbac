package com.jackieyang.rbac.mapper;

import com.jackieyang.rbac.entity.pojo.UserRolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RbacMapper {

    /**
     * query user role permission by user id
     * @param userId userId
     * @return List<UserRolePermission>
     */
    List<UserRolePermission> queryUserRolePermissionByUserId(Long userId);
}
