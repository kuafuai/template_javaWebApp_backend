package com.aiassistant.service.impl;

import com.aiassistant.mapper.TeacherMapper;
import com.aiassistant.model.Teacher;
import com.aiassistant.service.TeacherService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

    private final TeacherMapper teacherMapper;

    @Autowired
    public TeacherServiceImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public ResultModel<Teacher> addTeacher(Teacher teacher) {
        try {
            if (teacher == null) {
                return ResultModel.ofError("Teacher object is null");
            }
            if (teacher.getName() == null || teacher.getName().isEmpty()) {
                return ResultModel.ofError("Teacher name is required");
            }
            teacherMapper.insertTeacher(teacher);
            return ResultModel.ofSuccess(teacher);
        } catch (Exception e) {
            logger.error("Failed to add teacher", e);
            return ResultModel.ofError("Failed to add teacher", e);
        }
    }

    @Override
    public ResultModel<List<Teacher>> getTeacherList() {
        try {
            List<Teacher> teachers = teacherMapper.getTeacherList();
            return ResultModel.ofSuccess(teachers);
        } catch (Exception e) {
            logger.error("Failed to get teacher list", e);
            return ResultModel.ofError("Failed to get teacher list", e);
        }
    }
}