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

import java.util.ArrayList;
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
        return ResultPageModel.of(cableMapper.getCableList(new Cable()));
    }

    @Override
    public ResultPageModel<Cable> getCableListByProductCode(String productCode, Integer pageNum, Integer pageSize) {

        ResultPageModel pageModel = new ResultPageModel(pageNum, pageSize);
        Cable cable = new Cable();
        cable.setProductCode(productCode);
        cable.setIsDefault(true);
        cable.setStart(pageModel.getFirstIndex());
        cable.setLimit(pageModel.getPageSize());

        int count = cableMapper.countCable(cable);
        List<Cable> list = cableMapper.getCableList(cable);

        pageModel.setTotalRecords(count);
        pageModel.setList(list);

        return pageModel;
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
        int success = 0;
        List<Cable> batchList = new ArrayList<>();
        for (int i = 2; i < excelData.size(); i++) {
            List<String> rowList = excelData.get(i);
            String projectNumber = String.valueOf(rowList.get(0));
            String productCode = String.valueOf(rowList.get(1));

            String versionNumber = String.valueOf(rowList.get(2));
            boolean isDefault = StringUtils.equalsIgnoreCase(String.valueOf(rowList.get(3)), "是") ? true : false;

            String productName = String.valueOf(rowList.get(4));
            String componentCode = String.valueOf(rowList.get(5));
            String cableSpecification = String.valueOf(rowList.get(6));
            String lineNumber = String.valueOf(rowList.get(7));
            String length = String.valueOf(rowList.get(8));
            String leftPeelOuter = String.valueOf(rowList.get(9));
            String leftPeelInner = String.valueOf(rowList.get(10));
            String rightPeelOuter = String.valueOf(rowList.get(11));
            String rightPeelInner = String.valueOf(rowList.get(12));
            String sprayCode = String.valueOf(rowList.get(13));
            String leftPeelOuterProcess = String.valueOf(rowList.get(14));
            String leftShieldProcess = String.valueOf(rowList.get(15));
            String leftPeelInnerProcess = String.valueOf(rowList.get(16));
            String rightPeelOuterProcess = String.valueOf(rowList.get(17));
            String rightShieldProcess = String.valueOf(rowList.get(19));
            String rightPeelInnerProcess = String.valueOf(rowList.get(19));

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
            cable.setIsDefault(isDefault);
            cable.setVersionNumber(versionNumber);

            if (batchList.size() >= 100) {
                System.out.println("================ begin batch insert :" + batchList.size());
                cableMapper.batchInsert(batchList);
                batchList.clear();
                System.out.println("================ begin batch insert : " + batchList.size());
            } else {
                batchList.add(cable);
            }

            success++;
        }
        if (batchList.size() > 0) {
            System.out.println("end ================ begin batch insert : " + batchList.size());
            cableMapper.batchInsert(batchList);
            batchList.clear();
            System.out.println("end ================ begin batch insert : " + batchList.size());
        }

        return ResultModel.ofSuccess(success);
    }


    @Override
    public String print(String productCode, String number) {
        Cable cable = new Cable();
        cable.setProductCode(productCode);
        cable.setIsDefault(true);
        cable.setStart(0);
        cable.setLimit(1000);
        List<Cable> list = cableMapper.getCableList(cable);

        String baseBodyFormatter = "<tr>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                </tr>";
        String qjBodyFormatter = "<tr>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                </tr>";
        String xlBodyFormatter = "<tr>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                    <td>%s</td>\n" +
                "                </tr>";

        StringBuilder baseSb = new StringBuilder();
        StringBuilder qjSb = new StringBuilder();
        StringBuilder xlSb = new StringBuilder();

        list.stream().forEach(p -> {

            String base = String.format(baseBodyFormatter, p.getProjectNumber(), p.getProductCode(),
                    p.getVersionNumber(), p.getProductName(), number, p.getComponentCode(), p.getCableSpecification(), p.getLineNumber());
            baseSb.append(base);

            String qj = String.format(qjBodyFormatter, p.getLength(), p.getLeftPeelOuter(), p.getLeftPeelInner(),
                    p.getRightPeelOuter(), p.getRightPeelInner(), p.getSprayCode());
            qjSb.append(qj);

            String xl = String.format(xlBodyFormatter, p.getLeftPeelOuterProcess(), p.getLeftShieldProcess(),
                    p.getLeftPeelInnerProcess(), p.getRightPeelOuterProcess(), p.getRightShieldProcess(), p.getRightPeelInnerProcess());
            xlSb.append(xl);


        });
        String result = String.format(getHtmlFormatter(), baseSb.toString(), qjSb.toString(), xlSb.toString());
        return result;
    }

    private String getHtmlFormatter() {
        return "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>打印</title>\n" +
                "    <meta content=\"demo\" name=\"description\"></meta>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    <div style=\"height: 20px;\"></div>\n" +
                "    <div class=\"plan_box\">基础信息</div>\n" +
                "    <div style=\"height: 10px;\"></div>\n" +
                "    <div class=\"plan_box\">\n" +
                "        <table>\n" +
                "            <thead>\n" +
                "                <td class=\"head\" style=\"width: 100px;\">项目</td>\n" +
                "                <td class=\"head\" style=\"width: 150px;\">产品编码</td>\n" +
                "                <td class=\"head\" style=\"width: 100px;\">产品版本</td>\n" +
                "                <td class=\"head\" style=\"width: 200px;\">产品名称</td>\n" +
                "                <td class=\"head\" style=\"width: 100px;\">生产数量</td>\n" +
                "                <td class=\"head\" style=\"width: 150px;\">子件编码</td>\n" +
                "                <td class=\"head\" style=\"width: 300px;\">线缆规格型号</td>\n" +
                "                <td class=\"head\" style=\"width: 100px;\">线号（+-）</td>\n" +
                "            </thead>\n" +
                "            <tbody>\n" + "%s" +
                "            </tbody>\n" +
                "       </table>\n" +
                "    </div>\n" +
                "    <div style=\"height: 20px;\"></div>\n" +
                "    <div class=\"plan_box\">切线工艺参数</div>\n" +
                "    <div style=\"height: 10px;\"></div>\n" +
                "    <div class=\"plan_box\">\n" +
                "        <table>\n" +
                "            <thead>\n" +
                "                <td class=\"head\" style=\"width: 200px;\">长度/mm</td>\n" +
                "                <td class=\"head\" style=\"width: 200px;\">左剥外皮/mm</td>\n" +
                "                <td class=\"head\" style=\"width: 200px;\">左剥内皮/mm</td>\n" +
                "                <td class=\"head\" style=\"width: 200px;\">右剥外皮/mm</td>\n" +
                "                <td class=\"head\" style=\"width: 200px;\">右剥内皮/mm</td>\n" +
                "                <td class=\"head\" style=\"width: 200px;\">标记 / 喷码</td>\n" +
                "            </thead>\n" +
                "            <tbody>\n" + "%s" +
                "            </tbody>\n" +
                "       </table>\n" +
                "    </div>\n" +
                "    <div style=\"height: 20px;\"></div>\n" +
                "    <div class=\"plan_box\">线缆处理工艺参数</div>\n" +
                "    <div style=\"height: 10px;\"></div>\n" +
                "    <div class=\"plan_box\">\n" +
                "        <table>\n" +
                "            <thead>\n" +
                "                <td class=\"head\" style=\"width: 200px;\">左剥外皮/mm</td>\n" +
                "                <td class=\"head\" style=\"width: 200px;\">左屏蔽处理/mm</td>\n" +
                "                <td class=\"head\" style=\"width: 200px;\">左剥内皮/mm</td>\n" +
                "                <td class=\"head\" style=\"width: 200px;\">右剥外皮/mm</td>\n" +
                "                <td class=\"head\" style=\"width: 200px;\">右屏蔽处理/mm</td>\n" +
                "                <td class=\"head\" style=\"width: 200px;\">右剥内皮/mm</td>\n" +
                "            </thead>\n" +
                "            <tbody>\n" + "%s" +
                "            </tbody>\n" +
                "       </table>\n" +
                "    </div>\n" +
                "  </body>\n" +
                "  <style>\n" +
                "    .plan_box {\n" +
                "        overflow: hidden;\n" +
                "        display: flex;\n" +
                "        align-items: center;\n" +
                "        justify-content: center;\n" +
                "    }\n" +
                "    .plan_box table {\n" +
                "        border-spacing: 0;\n" +
                "        border-collapse: collapse;\n" +
                "    }\n" +
                "    .plan_box table thead tr:nth-child(2n+1) {\n" +
                "        background-color: #FAFAFA;\n" +
                "    }\n" +
                "\n" +
                "    th,td {\n" +
                "        border: 1px solid #666666;\n" +
                "        text-align: center;\n" +
                "        padding: 20px 5px;\n" +
                "    }\n" +
                "    .plan_box table tr {\n" +
                "        height: 40px;\n" +
                "        font-size: 14px;\n" +
                "        color: #666666;\n" +
                "        line-height: 14px;\n" +
                "        font-weight: 400;\n" +
                "    }\n" +
                "    .plan_box table tr:nth-child(2n) {\n" +
                "        background-color: #FAFAFA;\n" +
                "    }\n" +
                "    .plan_box table .head {\n" +
                "        font-size: 14px;\n" +
                "        color: #666666;\n" +
                "        line-height: 14px;\n" +
                "        font-weight: 600;\n" +
                "    }\n" +
                "  </style>\n" +
                "</html>";
    }


}
