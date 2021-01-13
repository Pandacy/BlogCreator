package com.bc.springboot.repository;

import com.bc.springboot.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportRepository extends JpaRepository<Report, Integer> {
}