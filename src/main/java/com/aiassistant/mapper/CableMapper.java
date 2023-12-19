package com.aiassistant.mapper;

import com.aiassistant.model.Cable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CableMapper {
    @Insert("INSERT INTO cable (project_number, product_code, product_name, component_code, cable_specification, line_number, length, left_peel_outer, left_peel_inner, right_peel_outer, right_peel_inner, spray_code, left_peel_outer_process, left_shield_process, left_peel_inner_process, right_peel_outer_process, right_shield_process, right_peel_inner_process,is_default,version_number) " +
            "VALUES (#{projectNumber}, #{productCode}, #{productName}, #{componentCode}, #{cableSpecification}, #{lineNumber}, #{length}, #{leftPeelOuter}, #{leftPeelInner}, #{rightPeelOuter}, #{rightPeelInner}, #{sprayCode}, #{leftPeelOuterProcess}, #{leftShieldProcess}, #{leftPeelInnerProcess}, #{rightPeelOuterProcess}, #{rightShieldProcess}, #{rightPeelInnerProcess}, #{isDefault},#{versionNumber})")
    Integer insertCable(Cable cable);

    @Select("SELECT * FROM cable")
    List<Cable> getCableList();

    @Select("SELECT * FROM cable where product_code like '%' || #{productCode} || '%'")
    List<Cable> getCableListByProductCode(String productCode);

    @Select("SELECT * FROM cable WHERE id = #{id}")
    Cable selectById(Integer id);
}
