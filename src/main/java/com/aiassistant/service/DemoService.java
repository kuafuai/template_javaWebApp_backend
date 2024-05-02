package com.aiassistant.service;

import com.aiassistant.model.Role;
import com.aiassistant.model.Reward;
import com.aiassistant.utils.ResultModel;

import java.util.List;

public interface DemoService {
    ResultModel<Role> addRole(Role role);
    ResultModel<Reward> addReward(Reward reward);
    ResultModel<List<Role>> getRoleList();
    ResultModel<List<Reward>> getRewardList();
    ResultModel<List<Reward>> getRewardListByRoleId(int roleId);
    ResultModel<Role> getRoleById(int id);
    ResultModel<Reward> getRewardById(int id);
}
