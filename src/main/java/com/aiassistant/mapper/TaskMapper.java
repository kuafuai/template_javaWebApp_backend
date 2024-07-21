package com.aiassistant.mapper;

import com.aiassistant.model.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper {
    
    Task insertTask(Task task);
    
    List<Task> getTaskList();
    
    Task selectById(@Param("taskId") Integer taskId);
    
    int updateTask(Task task);
    
    int deleteTask(@Param("taskId") Integer taskId);
}
