package com.bc.springboot.service;

import com.bc.springboot.model.Report;
import com.bc.springboot.model.User;
import com.bc.springboot.repository.IReportRepository;
import com.bc.springboot.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    @Autowired
    private IReportRepository reportRepository;

    public void AddReport(Report report)
    {
        reportRepository.save(report);
    }

    public List<Report> getReports()
    {
        return reportRepository.findAll();
    }

    public Report getReportById(int id)
    {
        return reportRepository.findById(id).orElse(null);
    }

    public String DeleteReport(int id){
        reportRepository.deleteById(id);
        return "Object Deleted";
    }

    public Report UpdateReport(Report report){
        Report reportData = reportRepository.findById(report.getId()).orElse(null);
        reportData.setTitle(report.getTitle());
        reportData.setDescription(report.getDescription());
        return reportRepository.save(reportData);
    }
}
