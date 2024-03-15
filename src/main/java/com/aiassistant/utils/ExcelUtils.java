package com.aiassistant.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtils {
    public static void generateExcel(List<StoreFeedback> storeFeedbackList, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Store Feedback");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Store ID");
        headerRow.createCell(1).setCellValue("Feedback Date");
        headerRow.createCell(2).setCellValue("Feedback Content");

        // Create data rows
        int rowNum = 1;
        for (StoreFeedback storeFeedback : storeFeedbackList) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(storeFeedback.getStoreId());
            row.createCell(1).setCellValue(storeFeedback.getFeedbackDate());
            row.createCell(2).setCellValue(storeFeedback.getFeedbackContent());
        }

        // Auto-size columns
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the workbook to a file
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
