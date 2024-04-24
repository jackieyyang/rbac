package com.jackieyang.rbac.mapper;

import com.jackieyang.rbac.entity.pojo.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    /**
     * query all user roles
     * @return List<UserRole>
     */
    List<UserRole> queryUserRoles();

    /**
     * query user role by user id
     * @return List<UserRole>
     */
    List<UserRole> queryUserRoleByUserId(Long userId);

    /**
     * insert user role by role id
     * @param userId userId
     * @param roleId roleId
     */
    @Insert("insert into user_role_relation(user_id, role_id) values(#{userId}, #{roleId})")
    void insertUserRoleByUserIdAndRoleId(Long userId, Long roleId);

    /**
     * delete user role by user id and role id
     * @param userId userId
     * @param roleId roleId
     */
    @Delete("delete from user_role_relation where user_id=#{userId} and role_id=#{roleId}")
    void deleteUserRoleByUserIdAndRoleId(Long userId, Long roleId);

    /**
     * delete user role by user id
     * @param userId userId
     */
    @Delete("delete from user_role_relation where user_id=#{userId}")
    void deleteUserRoleByUserId(Long userId);

    /**
     * delete user role by role id
     * @param roleId roleId
     */
    @Delete("delete from user_role_relation where role_id=#{roleId}")
    void deleteUserRoleByRoleId(Long roleId);
}
