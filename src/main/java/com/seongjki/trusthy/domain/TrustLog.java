package com.seongjki.trusthy.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class TrustLog {

    private long id;

    private UUID trustAccountId;

    private float delta;

    private String reason;

    private LocalDateTime createdAt;

    public TrustLog(UUID trustAccountId, float delta, String reason, LocalDateTime createdAt) {
        this.trustAccountId = trustAccountId;
        this.delta = delta;
        this.reason = reason;
        this.createdAt = createdAt;
    }

}
