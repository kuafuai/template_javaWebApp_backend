package com.aiassistant.service.impl;

import com.aiassistant.mapper.CableMapper;
import com.aiassistant.model.Cable;
import com.aiassistant.service.CableService;
import com.aiassistant.utils.ExcelUtils;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CableServiceImpl implements CableService {

    private final CableMapper cableMapper;

    @Autowired
    public CableServiceImpl(CableMapper cableMapper) {
        this.cableMapper = cableMapper;
    }

    @Override
    public ResultModel addCable(Cable cable) {
        cableMapper.insertCable(cable);
        return ResultModel.ofSuccess(cable);
    }

    @Override
    public ResultPageModel<Cable> getCableList() {
        return ResultPageModel.of(cableMapper.getCableList());
    }

    @Override
    public ResultModel<Cable> getCableById(Integer id) {
        Cable cable = cableMapper.selectById(id);
        if (cable != null) {
            return ResultModel.ofSuccess(cable);
        } else {
            return ResultModel.ofError("Cable not found");
        }
    }

    @Override
    public ResultModel uploadExcel(MultipartFile file) {

        List<List<String>> excelData = ExcelUtils.readExcel(file);
        for (int i = 2; i < excelData.size(); i++) {
            List<String> rowList = excelData.get(i);
            String projectNumber = String.valueOf(rowList.get(0));
            String productCode = String.valueOf(rowList.get(1));
            String productName = String.valueOf(rowList.get(2));
            String componentCode = String.valueOf(rowList.get(3));
            String cableSpecification = String.valueOf(rowList.get(4));
            String lineNumber = String.valueOf(rowList.get(5));
            String length = String.valueOf(rowList.get(6));
            String leftPeelOuter = String.valueOf(rowList.get(7));
            String leftPeelInner = String.valueOf(rowList.get(8));
            String rightPeelOuter = String.valueOf(rowList.get(9));
            String rightPeelInner = String.valueOf(rowList.get(10));
            String sprayCode = String.valueOf(rowList.get(11));
            String leftPeelOuterProcess = String.valueOf(rowList.get(12));
            String leftShieldProcess = String.valueOf(rowList.get(13));
            String leftPeelInnerProcess = String.valueOf(rowList.get(14));
            String rightPeelOuterProcess = String.valueOf(rowList.get(15));
            String rightShieldProcess = String.valueOf(rowList.get(16));
            String rightPeelInnerProcess = String.valueOf(rowList.get(17));

            if (StringUtils.isBlank(projectNumber) && StringUtils.isBlank(productCode)) {
                continue;
            }

            Cable cable = new Cable();
            cable.setProjectNumber(projectNumber);
            cable.setProductCode(productCode);
            cable.setProductName(productName);
            cable.setComponentCode(componentCode);
            cable.setCableSpecification(cableSpecification);
            cable.setLineNumber(lineNumber);
            cable.setLength(length);
            cable.setLeftPeelOuter(leftPeelOuter);
            cable.setLeftPeelInner(leftPeelInner);
            cable.setRightPeelOuter(rightPeelOuter);
            cable.setRightPeelInner(rightPeelInner);
            cable.setSprayCode(sprayCode);
            cable.setLeftPeelOuterProcess(leftPeelOuterProcess);
            cable.setLeftShieldProcess(leftShieldProcess);
            cable.setLeftPeelInnerProcess(leftPeelInnerProcess);
            cable.setRightPeelOuterProcess(rightPeelOuterProcess);
            cable.setRightShieldProcess(rightShieldProcess);
            cable.setRightPeelInnerProcess(rightPeelInnerProcess);

            cableMapper.insertCable(cable);
        }

        return ResultModel.ofSuccess("OK");
    }
}
