package com.seongjki.trusthy.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Report {

    private UUID id;

    private ReportCategory category;

    private String content;

    private UUID communityId;

    private UUID senderId;

    private UUID targetId;

    private UUID targetPostId;

    private LocalDateTime createdAt;

    private ReportStatus status;

    public Report(UUID id, ReportCategory category, String content, UUID communityId, UUID senderId, UUID targetId, UUID targetPostId, LocalDateTime createdAt) {
        this.id = id;
        this.category = category;
        this.content = content;
        this.communityId = communityId;
        this.senderId = senderId;
        this.targetId = targetId;
        this.targetPostId = targetPostId;
        this.createdAt = createdAt;
        this.status = ReportStatus.WAITING;
    }

    public enum ReportStatus {
        WAITING,
        ACCEPTED,
        REJECTED,
    }

    public void process(ReportStatus status) {
        this.status = status;
    }

}

