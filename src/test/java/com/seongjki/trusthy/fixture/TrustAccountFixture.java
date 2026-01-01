package com.seongjki.trusthy.fixture;

import com.seongjki.trusthy.domain.TrustAccount;
import com.seongjki.trusthy.persistence.TrustAccountRepository;
import java.util.UUID;

public class TrustAccountFixture {

    public static TrustAccount createTrustAccount(TrustAccountRepository trustAccountRepository) {
        return trustAccountRepository.save(new TrustAccount(UUID.randomUUID()));
    }

}
