package com.aiassistant.mapper;

import com.aiassistant.model.Report;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReportMapper {
    @Select("SELECT * FROM report WHERE YEAR(create_time) = #{year} AND MONTH(create_time) = #{month}")
    List<Report> selectByYearAndMonth(@Param("year") Integer year, @Param("month") Integer month);

    @Insert("INSERT INTO report(title, content, create_time) VALUES(#{title}, #{content}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertReport(Report report);

    @Update("UPDATE report SET title = #{title}, content = #{content} WHERE id = #{id}")
    int updateReport(Report report);

    @Delete("DELETE FROM report WHERE id = #{id}")
    int deleteReport(@Param("id") Integer id);

    @Select("SELECT * FROM report WHERE id = #{id}")
    Report selectById(@Param("id") Integer id);

    @Select("SELECT * FROM report WHERE title LIKE CONCAT('%', #{keyword}, '%')")
    List<Report> searchReport(@Param("keyword") String keyword);

    @Select("SELECT * FROM report WHERE YEAR(create_time) = #{year} AND MONTH(create_time) = #{month} AND department = #{department} AND position = #{position} AND stage = #{stage}")
    List<Report> selectByDepartment(@Param("year") Integer year, @Param("month") Integer month, @Param("department") String department, @Param("position") String position, @Param("stage") String stage);

    @Select("SELECT * FROM report WHERE YEAR(create_time) = #{year} AND MONTH(create_time) = #{month} AND department = #{department} AND position = #{position} AND stage = #{stage}")
    List<Report> selectByCondition(@Param("year") Integer year, @Param("month") Integer month, @Param("department") String department, @Param("position") String position, @Param("stage") String stage);
}
