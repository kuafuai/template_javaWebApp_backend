package com.aiassistant.service.impl;

import com.aiassistant.mapper.TeacherMapper;
import com.aiassistant.model.Teacher;
import com.aiassistant.service.TeacherService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;

    @Autowired
    public TeacherServiceImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public ResultModel<Teacher> addTeacher(Teacher teacher) {
        try {
            teacherMapper.insertTeacher(teacher);
            return ResultModel.ofSuccess(teacher);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to add teacher", e);
        }
    }

    @Override
    public ResultPageModel<Teacher> getTeacherList() {
        try {
            return ResultPageModel.of(teacherMapper.getTeacherList());
        } catch (Exception e) {
            return ResultPageModel.ofError("Failed to get teacher list", e);
        }
    }
}
