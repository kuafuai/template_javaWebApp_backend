package com.aiassistant.mapper;

import com.aiassistant.model.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    Teacher insertTeacher(Teacher teacher);

    List<Teacher> getTeacherList();
}
