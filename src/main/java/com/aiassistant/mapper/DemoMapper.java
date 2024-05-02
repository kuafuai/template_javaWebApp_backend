package com.aiassistant.mapper;

import com.aiassistant.model.Role;
import com.aiassistant.model.Reward;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DemoMapper {
    Role insertRole(Role role);
    Reward insertReward(Reward reward);
    List<Role> getRoleList();
    List<Reward> getRewardList();
    List<Reward> getRewardListByRoleId(@Param("roleId") int roleId);
    Role selectRoleById(@Param("id") int id);
    Reward selectRewardById(@Param("id") int id);
}
