package com.bc.springboot.controller;

import com.bc.springboot.model.Report;
import com.bc.springboot.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/report", produces = "application/json")
public class ReportController {
    @Autowired
    private ReportService reportService;

    public ReportController(){

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable final int id) {
        return ResponseEntity.ok(reportService.getReportById(id));
    }

    @GetMapping
    public ResponseEntity<List<Report>> getReports(){
        List<Report> allReports = reportService.getReports();
        return ResponseEntity.ok(allReports);
    }

    @PostMapping
    public ResponseEntity<Report> create(@RequestBody final Report reportFromRequest) {
        Report report = new Report(reportFromRequest);
        reportService.AddReport(report);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reportService.getReportById(report.getId())).toUri();
        return ResponseEntity.created(uri).body(report);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Report> put(@RequestBody final Report reportFromRequest, @PathVariable final int id) {
        Report report = new Report(reportFromRequest);
        report.setId(id);
        reportService.UpdateReport(report);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reportService.getReportById(report.getId())).toUri();
        return ResponseEntity.created(uri).body(report);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<List<Report>> delete(@PathVariable final int id){
        reportService.DeleteReport(id);
        List<Report> allReports = reportService.getReports();
        return ResponseEntity.ok(allReports);
    }
}
