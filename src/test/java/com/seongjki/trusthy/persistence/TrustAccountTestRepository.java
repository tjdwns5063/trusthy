package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.TrustAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class TrustAccountTestRepository implements TrustAccountRepository {

    private final AtomicLong sequence = new AtomicLong();

    private List<TrustAccount> trustAccounts = new ArrayList<>();

    @Override
    public TrustAccount save(TrustAccount trustAccount) {
        trustAccount.assignId(sequence.incrementAndGet());
        trustAccounts.add(trustAccount);
        return trustAccount;
    }

    @Override
    public Optional<TrustAccount> findById(Long accountId) {
        return trustAccounts.stream().filter(acc -> acc.isSameId(accountId)).findFirst();
    }

}
