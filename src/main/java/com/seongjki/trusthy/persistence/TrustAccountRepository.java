package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.TrustAccount;

import java.util.Optional;

public interface TrustAccountRepository {

    TrustAccount save(TrustAccount trustAccount);

    Optional<TrustAccount> findById(Long accountId);

}
