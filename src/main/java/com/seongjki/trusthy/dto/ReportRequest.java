package com.seongjki.trusthy.dto;

import com.seongjki.trusthy.domain.ReportCategory;

import java.util.UUID;

public record ReportRequest (
        UUID communityId,
        UUID senderId,
        UUID reportedPostId,
        String content,
        ReportCategory category
) {
}
