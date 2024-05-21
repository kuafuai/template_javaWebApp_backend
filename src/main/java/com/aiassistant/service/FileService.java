package com.aiassistant.service;

import com.aiassistant.utils.FileUtils;
import com.aiassistant.utils.ResultModel;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    private final PdfService pdfService;
    private final OssService ossService;

    public FileService(PdfService pdfService, OssService ossService) {
        this.pdfService = pdfService;
        this.ossService = ossService;
    }

    public ResultModel<String> parseAndUploadZipFile(MultipartFile file) {
        try {
            // Step 1: Unzip the ZIP file
            String unzipPath = FileUtils.unzipFile(file);

            // Step 2: Parse and rename the PDF files
            pdfService.parseAndRenamePdfFiles(unzipPath);

            // Step 3: Upload the PDF files to OSS and generate an Excel file
            String excelUrl = ossService.uploadPdfFilesAndGenerateExcel(unzipPath);

            return ResultModel.ofSuccess(excelUrl);
        } catch (Exception e) {
            return ResultModel.ofError("Failed to parse and upload ZIP file", e);
        }
    }
}
