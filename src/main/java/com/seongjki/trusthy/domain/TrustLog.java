package com.seongjki.trusthy.domain;

import java.time.LocalDateTime;

public class TrustLog {

    public TrustLog(long trustAccountId, float delta, String reason, LocalDateTime createdAt) {
        this.trustAccountId = trustAccountId;
        this.delta = delta;
        this.reason = reason;
        this.createdAt = createdAt;
    }

    private long trustAccountId;

    private float delta;

    private String reason;

    private LocalDateTime createdAt;

}
