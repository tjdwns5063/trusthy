package com.seongjki.trusthy.domain.event;

import java.time.LocalDateTime;

public abstract class DomainEvent {


    private LocalDateTime createdAt;

    protected DomainEvent(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
