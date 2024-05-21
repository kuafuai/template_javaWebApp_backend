package com.aiassistant.service;

import com.aiassistant.model.PdfInfo;
import com.aiassistant.utils.ResultModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PdfService {

    public ResultModel<PdfInfo> parsePdfFile(File pdfFile) {
        ResultModel<PdfInfo> resultModel = new ResultModel<>();
        PdfInfo pdfInfo = new PdfInfo();

        try {
            PDDocument document = PDDocument.load(pdfFile);
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);

            // Extract case number
            String caseNumber = extractCaseNumber(text);
            pdfInfo.setCaseNumber(caseNumber);

            // Extract defendant name
            String defendantName = extractDefendantName(text);
            pdfInfo.setDefendantName(defendantName);

            resultModel.setData(pdfInfo);
            resultModel.setCode(200);
            resultModel.setMsg("Success");
        } catch (IOException e) {
            resultModel.setCode(500);
            resultModel.setMsg("Failed to parse PDF file");
            resultModel.setException(e);
        }

        return resultModel;
    }

    private String extractCaseNumber(String text) {
        // TODO: Implement case number extraction logic
        return null;
    }

    private String extractDefendantName(String text) {
        // TODO: Implement defendant name extraction logic
        return null;
    }
}
