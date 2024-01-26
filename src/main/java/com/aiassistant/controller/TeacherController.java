package com.aiassistant.controller;

import com.aiassistant.model.Teacher;
import com.aiassistant.service.TeacherService;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/add")
    public ResultModel addTeacher(Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @PostMapping("/list")
    public ResultPageModel<Teacher> getTeacherList() {
        return teacherService.getTeacherList();
    }
}
