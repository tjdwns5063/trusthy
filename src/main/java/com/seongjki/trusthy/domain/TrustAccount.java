package com.seongjki.trusthy.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import lombok.Getter;
import lombok.ToString;

@ToString
public class TrustAccount {

    @Getter
    private UUID id;

    private float trust;

    private TrustLevel level;

    public TrustAccount(UUID id) {
        this.id = id;
        this.trust = TrustEvent.CREATE_MEMBER.delta;
        this.calcLevel();
    }

    public void apply(float delta) {
        this.trust += delta;
        this.calcLevel();
    }

    public boolean isSameId(UUID trustId) {
        return Objects.equals(this.id, trustId);
    }

    private void calcLevel() {
        this.level = TrustLevel.of(this.trust);
    }

    public enum TrustLevel {
        EX_HIGH(25.0,Double.MAX_VALUE),
        HIGH(15.0, 25.0),
        MEDIUM(5.0, 15.0),
        LOW(-5.0,5.0),
        EX_LOW(-15.0, -5.0),
        RESTRICTED(Double.MIN_VALUE, -15.0);

        public final double min;

        public final double max;

        TrustLevel(double min, double max) {
            this.max = max;
            this.min = min;
        }

        public static TrustLevel of(double trust) {
            return Arrays.stream(TrustLevel.values())
                    .filter(l -> trust >= l.min && trust < l.max)
                    .findFirst()
                    .orElseThrow();
        }

        public double getWeight() {
            if (this == TrustLevel.RESTRICTED) {
                return this.max - 10;
            }
            return this.min;
        }

    }

}
