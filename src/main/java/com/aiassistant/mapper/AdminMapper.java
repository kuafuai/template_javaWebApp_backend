package com.aiassistant.mapper;

import com.aiassistant.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    int updatePassword(@Param("adminId") Integer adminId, @Param("newPassword") String newPassword);

    List<Admin> getAdminList(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);
}
