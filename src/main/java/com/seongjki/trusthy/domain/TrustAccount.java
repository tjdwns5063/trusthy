package com.seongjki.trusthy.domain;

public class TrustAccount {

    public TrustAccount(long id) {
        this.id = id;
        this.trust = TrustEvent.CREATE_MEMBER.delta;
    }

    private final long id;

    private float trust;

    public void apply(float delta) {
        this.trust += delta;
    }

    public boolean isSameId(long trustId) {
        return this.id == trustId;
    }

}
