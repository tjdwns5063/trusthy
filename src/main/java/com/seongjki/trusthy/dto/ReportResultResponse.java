package com.seongjki.trusthy.dto;

import com.seongjki.trusthy.domain.Report;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReportResultResponse(
        UUID id,

        UUID reportId,

        LocalDateTime createdAt,

        String reason,

        Report.ReportStatus fromStatus,

        Report.ReportStatus toStatus
) {
}
