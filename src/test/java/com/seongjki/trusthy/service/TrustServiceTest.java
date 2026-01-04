package com.seongjki.trusthy.service;

import com.seongjki.trusthy.domain.TrustAccount;
import com.seongjki.trusthy.domain.TrustEvent;
import com.seongjki.trusthy.dto.ApplyEventResponse;
import com.seongjki.trusthy.persistence.TrustAccountTestRepository;
import com.seongjki.trusthy.persistence.TrustLogTestRepository;
import java.util.UUID;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TrustServiceTest {

    private TrustService trustService;

    private TrustAccountTestRepository trustAccountTestRepository;

    private TrustLogTestRepository trustLogTestRepository;

    TrustServiceTest() {
        Clock clock = Clock.fixed(LocalDateTime.of(2025,12,29,12,0,0).toInstant(ZoneOffset.of("+9")), ZoneId.systemDefault());
        this.trustAccountTestRepository = new TrustAccountTestRepository();
        this.trustLogTestRepository = new TrustLogTestRepository();
        this.trustService = new TrustService(clock, trustAccountTestRepository, trustLogTestRepository);
    }

    @Test
    void applyTrustByEvent() {
        //given
        TrustEvent trustEvent = TrustEvent.CREATE_MEMBER;
        TrustAccount account = new TrustAccount(UUID.randomUUID());
        trustAccountTestRepository.save(account);

        //when
        ApplyEventResponse response = trustService.applyEvent(account.getId(), trustEvent);

        //then
        assertThat(response).isEqualTo(new ApplyEventResponse(account.getId(), true, LocalDateTime.of(2025,12,29,12,0,0)));
    }

}
