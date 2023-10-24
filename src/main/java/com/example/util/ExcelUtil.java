package com.example.util;

import com.example.model.Store;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtil {

    public void generateExcel(List<Store> stores) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Store Data");

        // Create header row
        Row headerRow = sheet.createRow(0);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Name");
        headerCell.setCellStyle(headerCellStyle);

        // Create data rows
        int rowNum = 1;
        for (Store store : stores) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(store.getName());
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < sheet.getRow(0).getPhysicalNumberOfCells(); i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the workbook to a file
        try (FileOutputStream fileOut = new FileOutputStream("store_data.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
