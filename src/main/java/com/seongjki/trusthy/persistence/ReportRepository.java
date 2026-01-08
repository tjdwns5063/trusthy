package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.Report;

import java.util.Optional;
import java.util.UUID;

public interface ReportRepository {

    Report save(Report report);

    Optional<Report> findById(UUID reportId);

}
