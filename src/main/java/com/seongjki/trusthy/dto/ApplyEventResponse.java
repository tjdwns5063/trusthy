package com.seongjki.trusthy.dto;

import java.time.LocalDateTime;

public record ApplyEventResponse(
        long accountId,
        boolean isSuccess,
        LocalDateTime appliedAt
) {

}
