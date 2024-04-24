package com.jackieyang.rbac.mapper;

import com.jackieyang.rbac.entity.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {

    /**
     * query all roles
     * @return List<Role>
     */
    @Select("select * from role")
    List<Role> queryRoles();

    /**
     * insert new role
     * @param role role
     */
    @Insert("insert into role(role_name, role_desc) values(#{roleName}, #{roleDesc})")
    void insertRole(Role role);

    /**
     * update role by id
     * @param role role
     */
    @Update("update role set role_name=#{roleName}, role_desc=#{roleDesc} where id=#{id}")
    void updateRoleById(Role role);

    /**
     * delete role by id
     * @param roleId roleId
     */
    @Delete("delete from role where id=#{roleId}")
    void deleteRoleById(Long roleId);
}
