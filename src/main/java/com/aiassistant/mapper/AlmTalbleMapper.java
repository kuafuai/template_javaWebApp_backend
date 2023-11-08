package com.aiassistant.mapper;

import com.aiassistant.model.AlmModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AlmTalbleMapper {

    @Insert("insert into alm_table (unique_key, due_date, export_time, status) values (#{uniqueKey},#{dueDate},#{exportTime},0)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(AlmModel model);

    @Select("select * from alm_table where unique_key = #{uniqueKey}")
    AlmModel getByUniqueKey(String uniqueKey);
}
