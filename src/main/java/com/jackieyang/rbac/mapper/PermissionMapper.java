package com.jackieyang.rbac.mapper;

import com.jackieyang.rbac.entity.pojo.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PermissionMapper {

    /**
     * query all permissions
     * @return List<Permission>
     */
    @Select("select * from permission")
    List<Permission> queryPermission();

    /**
     * insert new permission
     * @param permission permission
     */
    @Insert("insert into permission(allow_path, allow_method, permission_desc) values(#{allowPath}, #{allowMethod}, #{permissionDesc})")
    void insertPermission(Permission permission);

    /**
     * update permission by id
     * @param permission permission
     */
    @Update("update permission set allow_path=#{allowPath}, allow_method=#{allowMethod}, permission_desc=#{permissionDesc} where id=#{id}")
    void updatePermission(Permission permission);

    /**
     * delete permission by id
     * @param permissionId permissionId
     */
    @Delete("delete from permission where id=#{permissionId}")
    void deletePermission(Long permissionId);

}
