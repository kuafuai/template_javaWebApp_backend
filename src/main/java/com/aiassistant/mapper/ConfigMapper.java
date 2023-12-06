package com.aiassistant.mapper;

import com.aiassistant.model.Config;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ConfigMapper {
    @Insert("INSERT INTO config(app_code, key, value, status) VALUES(#{appCode}, #{key}, #{value}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertConfig(Config config);

    @Update("UPDATE config SET value = #{value} WHERE app_code = #{appCode} AND key = #{key}")
    int updateConfigValue(Config config);

    @Update("UPDATE config SET status = #{status} WHERE app_code = #{appCode} AND key = #{key}")
    int updateConfigStatus(Config config);

    @Select("SELECT value FROM config WHERE app_code = #{appCode} AND key = #{key}")
    String selectConfigValue(@Param("appCode") String appCode, @Param("key") String key);
}
