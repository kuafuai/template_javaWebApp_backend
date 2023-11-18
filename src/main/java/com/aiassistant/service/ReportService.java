package com.aiassistant.service;

import com.aiassistant.mapper.ReportMapper;
import com.aiassistant.model.Report;
import com.aiassistant.utils.ResultModel;
import com.aiassistant.utils.ResultPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class ReportService {
    @Autowired
    private ReportMapper reportMapper;

    public ResultPageModel<Report> getReportList(Integer year, Integer month) {
        // TODO: Implement this method
        return null;
    }

    public ResultModel addReport(Report report) {
        // TODO: Implement this method
        return null;
    }

    public ResultModel updateReport(Report report) {
        // TODO: Implement this method
        return null;
    }

    public ResultModel deleteReport(Integer id) {
        // TODO: Implement this method
        return null;
    }

    public ResultModel getReportDetail(Integer id) {
        // TODO: Implement this method
        return null;
    }

    public ResultPageModel<Report> searchReport(String keyword) {
        // TODO: Implement this method
        return null;
    }

    public ResultPageModel<Report> getDepartmentReportList(Integer year, Integer month, String department, String position, String stage) {
        // TODO: Implement this method
        return null;
    }

    public void exportReportData(Integer year, Integer month, String department, String position, String stage, HttpServletResponse response) {
        // TODO: Implement this method
    }
}
