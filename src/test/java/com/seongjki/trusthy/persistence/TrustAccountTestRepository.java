package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.TrustAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrustAccountTestRepository implements TrustAccountRepository {

    private List<TrustAccount> trustAccounts = new ArrayList<>();

    @Override
    public TrustAccount save(TrustAccount trustAccount) {
        trustAccounts.add(trustAccount);
        return trustAccount;
    }

    @Override
    public Optional<TrustAccount> findById(Long accountId) {
        return trustAccounts.stream().filter(acc -> acc.id == accountId).findFirst();
    }

}
