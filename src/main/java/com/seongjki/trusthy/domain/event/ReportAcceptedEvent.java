package com.seongjki.trusthy.domain.event;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class ReportAcceptedEvent extends DomainEvent {

    private UUID reportedMemberId;

    public ReportAcceptedEvent(LocalDateTime createdAt, UUID reportedMemberId) {
        super(createdAt);
        this.reportedMemberId = reportedMemberId;
    }

}
