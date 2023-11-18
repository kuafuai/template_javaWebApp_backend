package com.aiassistant.utils;

import com.aiassistant.model.Report;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExcelUtil {
    public static void exportToExcel(List<Report> reportList, HttpServletResponse response) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Report");

        // Create header row
        Row headerRow = sheet.createRow(0);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("ID");
        headerCell.setCellStyle(headerCellStyle);

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Name");
        headerCell.setCellStyle(headerCellStyle);

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Date");
        headerCell.setCellStyle(headerCellStyle);

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Description");
        headerCell.setCellStyle(headerCellStyle);

        // Create data rows
        int rowNum = 1;
        for (Report report : reportList) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(report.getId());
            row.createCell(1).setCellValue(report.getName());
            row.createCell(2).setCellValue(report.getDate());
            row.createCell(3).setCellValue(report.getDescription());
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < 4; i++) {
            sheet.autoSizeColumn(i);
        }

        // Set the response headers
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=report.xlsx");

        // Write the workbook to the response output stream
        try {
            workbook.write(response.getOutputStream());
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
