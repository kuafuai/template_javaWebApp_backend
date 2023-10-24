package com.example.util;

import com.example.model.Store;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class ExcelUtil {

    private static final String DEFAULT_FILE_NAME = "store_data.xlsx";
    private static final String DEFAULT_SHEET_NAME = "Store Data";

    public void generateExcel(List<Store> stores, String fileName, String sheetName) {
        validateInputParameters(fileName, sheetName);

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);

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
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            handleException("Error occurred while writing the Excel file: " + e.getMessage());
        } finally {
            // Close the workbook
            try {
                workbook.close();
            } catch (IOException e) {
                handleException("Error occurred while closing the workbook: " + e.getMessage());
            }
        }
    }

    public void generateExcel(List<Store> stores) {
        generateExcel(stores, DEFAULT_FILE_NAME, DEFAULT_SHEET_NAME);
    }

    private void validateInputParameters(String fileName, String sheetName) {
        if (Objects.isNull(fileName) || fileName.isEmpty()) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }
        if (Objects.isNull(sheetName) || sheetName.isEmpty()) {
            throw new IllegalArgumentException("Sheet name cannot be null or empty");
        }
    }

    private void handleException(String errorMessage) {
        // Log the exception and return a custom error message to the user
        throw new RuntimeException(errorMessage);
    }
}
