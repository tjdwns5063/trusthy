package com.seongjki.trusthy.domain;

public enum TrustEvent {

    CREATE_MEMBER("create_member", 5),
    CREATE_POST("create_post", 1),
    CREATE_COMMENT("create_comment", 0.5f),
    REPORTED("reported_by_user", -5),
    AUTHORIZED("authorized", 3),
    HELPFUL("helpful", 3);

    public final String reason;

    public final float delta;

    TrustEvent(String reason, float delta) {
        this.reason = reason;
        this.delta = delta;
    }

}
