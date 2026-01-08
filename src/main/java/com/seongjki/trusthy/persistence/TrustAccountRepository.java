package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.TrustAccount;

import java.util.Optional;
import java.util.UUID;

public interface TrustAccountRepository {

    TrustAccount save(TrustAccount trustAccount);

    Optional<TrustAccount> findById(UUID accountId);

    Optional<TrustAccount> findByMemberId(UUID memberId);

}
