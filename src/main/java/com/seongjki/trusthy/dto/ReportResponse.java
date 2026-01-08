package com.seongjki.trusthy.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReportResponse(
         UUID id,

         String category,

         String content,

         UUID communityId,

         UUID senderId,

         UUID targetId,

         UUID targetPostId,

         LocalDateTime createdAt,

         String status
) {
}
