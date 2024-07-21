package com.aiassistant.service;

import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import com.aiassistant.model.Task;

import java.util.List;

public interface TaskService {
    ResultModel<Task> addTask(Task task);
    ResultModel<Task> editTask(Task task);
    ResultModel<String> deleteTask(Integer taskId);
    ResultPageModel<Task> getTaskList();
    ResultModel<String> completeTask(Integer taskId);
}
