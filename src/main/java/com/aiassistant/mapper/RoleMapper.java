package com.aiassistant.mapper;

import com.aiassistant.model.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleMapper {
    @Insert("INSERT INTO role(role_name, role_desc) VALUES(#{roleName}, #{roleDesc})")
    @Options(useGeneratedKeys = true, keyProperty = "roleId", keyColumn = "role_id")
    void insertRole(Role role);

    @Select("SELECT * FROM role WHERE role_id = #{roleId}")
    Role selectById(Integer roleId);

    @Select("SELECT * FROM role")
    List<Role> selectAll();

    @Update("UPDATE role SET role_name = #{roleName}, role_desc = #{roleDesc} WHERE role_id = #{roleId}")
    void updateRole(Role role);

    @Delete("DELETE FROM role WHERE role_id = #{roleId}")
    void deleteRole(Integer roleId);
}
