package com.seongjki.trusthy.domain;

import java.time.LocalDateTime;

public class TrustLog {

    private long id;

    private long trustAccountId;

    private float delta;

    private String reason;

    private LocalDateTime createdAt;

    public TrustLog(long trustAccountId, float delta, String reason, LocalDateTime createdAt) {
        this.trustAccountId = trustAccountId;
        this.delta = delta;
        this.reason = reason;
        this.createdAt = createdAt;
    }

}
