package com.aiassistant.mapper;

import com.aiassistant.model.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    int updateAdminPassword(@Param("adminId") Integer adminId, @Param("newPassword") String newPassword);

    List<Admin> getAdminList();

    Admin selectById(Integer adminId);
}
