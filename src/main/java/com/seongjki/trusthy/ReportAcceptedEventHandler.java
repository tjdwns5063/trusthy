package com.seongjki.trusthy;

import com.seongjki.trusthy.domain.TrustEvent;
import com.seongjki.trusthy.domain.event.ReportAcceptedEvent;
import com.seongjki.trusthy.service.TrustService;
import org.springframework.context.event.EventListener;

public class ReportAcceptedEventHandler {

    private final TrustService trustService;

    public ReportAcceptedEventHandler(TrustService trustService) {
        this.trustService = trustService;
    }

    @EventListener //TODO: TransactionalEventListener로 추후 수정
    public void handle(ReportAcceptedEvent e) {
        trustService.applyEventByMemberId(e.getReportedMemberId(), TrustEvent.REPORTED);
    }


}
