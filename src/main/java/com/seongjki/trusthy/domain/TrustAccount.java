package com.seongjki.trusthy.domain;

public class TrustAccount {

    public TrustAccount() {
        this.trust = TrustEvent.CREATE_MEMBER.delta;
    }

    private Long id;

    private float trust;

    public void assignId(long id) {
        if (this.id != null) {
            return ;
        }
        this.id = id;
    }

    public void apply(float delta) {
        this.trust += delta;
    }

    public boolean isSameId(long trustId) {
        return this.id == trustId;
    }

}
