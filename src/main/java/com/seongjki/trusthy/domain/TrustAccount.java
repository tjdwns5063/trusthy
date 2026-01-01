package com.seongjki.trusthy.domain;

import java.util.Arrays;
import java.util.Objects;
import lombok.ToString;

@ToString
public class TrustAccount {

    private Long id;

    private float trust;

    private TrustLevel level;

    public TrustAccount() {
        this.trust = TrustEvent.CREATE_MEMBER.delta;
        this.calcLevel();
    }

    public void assignId(long id) {
        if (this.id != null) {
            return ;
        }
        this.id = id;
    }

    public void apply(float delta) {
        this.trust += delta;
        this.calcLevel();
    }

    public boolean isSameId(long trustId) {
        return Objects.equals(this.id, trustId);
    }

    private void calcLevel() {
        this.level = TrustLevel.of(this.trust);
    }

    public enum TrustLevel {
        EX_HIGH(25.0f,Float.MAX_VALUE),
        HIGH(15.0f, 25.0f),
        MEDIUM(5.0f, 15.0f),
        LOW(-5.0f,5.0f),
        EX_LOW(-15.0f, -5.0f),
        RESTRICTED(Float.MIN_VALUE, -15.0f);

        public final float min;

        public final float max;

        TrustLevel(float min, float max) {
            this.max = max;
            this.min = min;
        }

        public static TrustLevel of(float trust) {
            return Arrays.stream(TrustLevel.values())
                    .filter(l -> trust >= l.min && trust < l.max)
                    .findFirst()
                    .orElseThrow();
        }

    }

}
