package com.aiassistant.service.impl;

import com.aiassistant.mapper.TaskMapper;
import com.aiassistant.model.Task;
import com.aiassistant.model.User;
import com.aiassistant.service.TaskService;
import com.aiassistant.utils.ExperienceModel;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private User user; // Assuming there's a way to get the current user

    @Override
    public ResultModel<Task> addTask(Task task) {
        taskMapper.insertTask(task);
        return ResultModel.ofSuccess(task);
    }

    @Override
    public ResultModel<Task> editTask(Task task) {
        taskMapper.updateTask(task);
        return ResultModel.ofSuccess(task);
    }

    @Override
    public ResultModel<String> deleteTask(Integer taskId) {
        taskMapper.deleteTask(taskId);
        return ResultModel.ofSuccess("Task deleted successfully");
    }

    @Override
    public ResultPageModel<Task> getTaskList() {
        List<Task> tasks = taskMapper.getTaskList();
        return ResultPageModel.of(tasks);
    }

    @Override
    public ResultModel<String> completeTask(Integer taskId) {
        Task task = taskMapper.selectById(taskId);
        if (task != null) {
            task.setCompletionStatus(true);
            taskMapper.updateTask(task);

            // Calculate experience and coins
            ExperienceModel experienceModel = new ExperienceModel();
            int experiencePoints = calculateExperience(task.getPriority());
            int coins = calculateCoins(task.getPriority());
            
            user.setExperiencePoints(user.getExperiencePoints() + experiencePoints);
            user.setCoins(user.getCoins() + coins);
            // Optionally update user level based on new experiencePoints

            return ResultModel.ofSuccess("Task completed successfully. Earned " + experiencePoints + " points and " + coins + " coins.");
        }
        return ResultModel.ofError("Task not found");
    }

    private int calculateExperience(int priority) {
        // Simple logic for experience calculation based on priority
        return priority * 10; // Example: High priority gives more experience
    }

    private int calculateCoins(int priority) {
        // Simple logic for coin calculation based on priority
        return priority * 5; // Example: High priority gives more coins
    }
}
