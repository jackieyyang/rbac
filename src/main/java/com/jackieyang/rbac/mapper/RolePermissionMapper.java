package com.jackieyang.rbac.mapper;

import com.jackieyang.rbac.entity.pojo.RolePermission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RolePermissionMapper {
    /**
     * query all role permissions
     */
    List<RolePermission> queryRolePermissions();

    /**
     * query role permission by role id
     */
    List<RolePermission> queryRolePermissionByRoleId(Long roleId);

    /**
     * insert role permission by role id and permission id
     * @param roleId roleId
     * @param permissionId permissionId
     */
    @Insert("insert into role_permission_relation(role_id, permission_id) values(#{roleId}, #{permissionId})")
    void insertRolePermissionByRoleIdAndPermissionId(Long roleId, Long permissionId);

    /**
     * delete role permission by role id and permission id
     * @param roleId roleId
     * @param permissionId permissionId
     */
    @Delete("delete from role_permission_relation where role_id=#{roleId} and permission_id=#{permissionId}")
    void deleteRolePermissionByRoleIdAndPermissionId(Long roleId, Long permissionId);

    /**
     * delete role permission by role id
     * @param roleId roleId
     */
    @Delete("delete from role_permission_relation where role_id=#{roleId}")
    void deleteRolePermissionByRoleId(Long roleId);

    /**
     * delete role permission by permission id
     * @param permissionId permissionId
     */
    @Delete("delete from role_permission_relation where permission_id=#{permissionId}")
    void deleteRolePermissionByPermissionId(Long permissionId);
}
