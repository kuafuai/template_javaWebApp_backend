package com.aiassistant.service;

import com.aiassistant.model.Teacher;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;

public interface TeacherService {
    ResultModel<Teacher> addTeacher(Teacher teacher);
    ResultPageModel<Teacher> getTeacherList();
}
