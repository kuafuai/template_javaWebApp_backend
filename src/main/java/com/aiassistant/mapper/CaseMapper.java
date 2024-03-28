package com.aiassistant.mapper;

import com.aiassistant.model.Case;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CaseMapper {
    Case insertCase(Case caseObj);

    List<Case> getCaseList();

    Case selectById(Integer id);
}
