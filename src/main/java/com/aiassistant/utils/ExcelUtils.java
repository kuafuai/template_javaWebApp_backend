package com.aiassistant.utils;

import com.aiassistant.model.PdfInfo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtils {
    public static Workbook createExcelFile(List<PdfInfo> pdfInfoList) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PDF Info");

        // Create header row
        Row headerRow = sheet.createRow(0);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("File Name");
        headerCell.setCellStyle(headerCellStyle);

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("File Size");
        headerCell.setCellStyle(headerCellStyle);

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Page Count");
        headerCell.setCellStyle(headerCellStyle);

        // Create data rows
        int rowNum = 1;
        for (PdfInfo pdfInfo : pdfInfoList) {
            Row row = sheet.createRow(rowNum++);

            Cell cell = row.createCell(0);
            cell.setCellValue(pdfInfo.getFileName());

            cell = row.createCell(1);
            cell.setCellValue(pdfInfo.getFileSize());

            cell = row.createCell(2);
            cell.setCellValue(pdfInfo.getPageCount());
        }

        // Auto-size columns
        for (int i = 0; i < 3; i++) {
            sheet.autoSizeColumn(i);
        }

        return workbook;
    }

    public static File createCsvFile(List<PdfInfo> pdfInfoList) throws IOException {
        File csvFile = new File("pdf_info.csv");
        FileOutputStream fileOutputStream = new FileOutputStream(csvFile);
        fileOutputStream.write("File Name,File Size,Page Count\n".getBytes());

        for (PdfInfo pdfInfo : pdfInfoList) {
            String csvLine = pdfInfo.getFileName() + "," + pdfInfo.getFileSize() + "," + pdfInfo.getPageCount() + "\n";
            fileOutputStream.write(csvLine.getBytes());
        }

        fileOutputStream.close();

        return csvFile;
    }
}
