package com.aiassistant.service.impl;

import com.aiassistant.mapper.RoleMapper;
import com.aiassistant.mapper.RewardMapper;
import com.aiassistant.model.Role;
import com.aiassistant.model.Reward;
import com.aiassistant.service.DemoService;
import com.aiassistant.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    private final RoleMapper roleMapper;
    private final RewardMapper rewardMapper;

    @Autowired
    public DemoServiceImpl(RoleMapper roleMapper, RewardMapper rewardMapper) {
        this.roleMapper = roleMapper;
        this.rewardMapper = rewardMapper;
    }

    @Override
    public ResultModel<Role> addRole(Role role) {
        try {
            roleMapper.insertRole(role);
            return ResultModel.ofSuccess(role);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add role", e);
        }
    }

    @Override
    public ResultModel<Reward> addReward(Reward reward) {
        try {
            rewardMapper.insertReward(reward);
            return ResultModel.ofSuccess(reward);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add reward", e);
        }
    }

    @Override
    public ResultModel<List<Role>> getRoleList() {
        try {
            List<Role> roleList = roleMapper.getRoleList();
            return ResultModel.ofSuccess(roleList);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get role list", e);
        }
    }

    @Override
    public ResultModel<List<Reward>> getRewardList() {
        try {
            List<Reward> rewardList = rewardMapper.getRewardList();
            return ResultModel.ofSuccess(rewardList);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get reward list", e);
        }
    }

    @Override
    public ResultModel<List<Reward>> getRewardListByRoleId(int roleId) {
        try {
            List<Reward> rewardList = rewardMapper.getRewardListByRoleId(roleId);
            return ResultModel.ofSuccess(rewardList);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get reward list by role id", e);
        }
    }

    @Override
    public ResultModel<Role> getRoleById(int id) {
        try {
            Role role = roleMapper.getRoleById(id);
            return ResultModel.ofSuccess(role);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get role by id", e);
        }
    }

    @Override
    public ResultModel<Reward> getRewardById(int id) {
        try {
            Reward reward = rewardMapper.getRewardById(id);
            return ResultModel.ofSuccess(reward);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to get reward by id", e);
        }
    }
}
