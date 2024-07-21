package com.aiassistant.controller;

import com.aiassistant.model.Task;
import com.aiassistant.service.TaskService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    
    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResultModel<Task> addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @PutMapping("/edit")
    public ResultModel<Task> editTask(@RequestBody Task task) {
        return taskService.editTask(task);
    }

    @DeleteMapping("/delete/{taskId}")
    public ResultModel<String> deleteTask(@PathVariable Integer taskId) {
        return taskService.deleteTask(taskId);
    }

    @GetMapping("/list")
    public ResultPageModel<Task> getTaskList() {
        return taskService.getTaskList();
    }

    @PostMapping("/complete/{taskId}")
    public ResultModel<String> completeTask(@PathVariable Integer taskId) {
        return taskService.completeTask(taskId);
    }
}
