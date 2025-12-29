package com.seongjki.trusthy.service;

import com.seongjki.trusthy.domain.TrustAccount;
import com.seongjki.trusthy.domain.TrustEvent;
import com.seongjki.trusthy.domain.TrustLog;
import com.seongjki.trusthy.dto.ApplyEventResponse;
import com.seongjki.trusthy.persistence.TrustAccountRepository;
import com.seongjki.trusthy.persistence.TrustLogRepository;

import java.time.Clock;
import java.time.LocalDateTime;

public class TrustService {

    private final Clock clock;

    private final TrustAccountRepository trustAccountRepository;

    private final TrustLogRepository trustLogRepository;

    public TrustService(Clock clock, TrustAccountRepository trustAccountRepository, TrustLogRepository trustLogRepository) {
        this.clock = clock;
        this.trustAccountRepository = trustAccountRepository;
        this.trustLogRepository = trustLogRepository;
    }

    public ApplyEventResponse applyEvent(long accountId, TrustEvent trustEvent) {
        TrustAccount trustAccount = trustAccountRepository.findById(accountId).orElseThrow();
        LocalDateTime now = LocalDateTime.now(clock);
        TrustLog log = new TrustLog(accountId, trustEvent.delta, trustEvent.reason, now);

        trustAccount.apply(trustEvent.delta);
        trustLogRepository.save(log);

        return new ApplyEventResponse(accountId, true, now);
    }

}
