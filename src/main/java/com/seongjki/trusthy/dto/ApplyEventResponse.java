package com.seongjki.trusthy.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ApplyEventResponse(
        UUID accountId,
        boolean isSuccess,
        LocalDateTime appliedAt
) {

}
