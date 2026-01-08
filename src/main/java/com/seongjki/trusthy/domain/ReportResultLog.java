package com.seongjki.trusthy.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class ReportResultLog {
    private UUID id;

    private UUID reportId;

    private LocalDateTime createdAt;

    private String reason;

    private Report.ReportStatus fromStatus;

    private Report.ReportStatus toStatus;


    public ReportResultLog(UUID id, UUID reportId, LocalDateTime createdAt, String reason, Report.ReportStatus fromStatus, Report.ReportStatus toStatus) {
        this.id = id;
        this.reportId = reportId;
        this.createdAt = createdAt;
        this.reason = reason;
        this.fromStatus = fromStatus;
        this.toStatus = toStatus;
    }
}
