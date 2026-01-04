package com.seongjki.trusthy.domain;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class ExposureScoreCalculator {

    private final Clock clock;

    private static final Double FRESHNESS_WEIGHT = 0.4;

    private static final Double COMMENT_WEIGHT = 0.1;

    private static final Double HELPFUL_WEIGHT = 0.2;

    private static final Double TRUST_WEIGHT = 0.3;

    public ExposureScoreCalculator(Clock clock) {
        this.clock = clock;
    }

    public Double calculate(Post post) {
        long freshness = post.getCreatedAt().toEpochSecond(ZoneOffset.of("+9")) -  LocalDateTime.now(clock).toEpochSecond(ZoneOffset.of("+9"));
        int commentCount = post.getCommentCount();
        int helpfulSum = post.getHelpfulSum();
        TrustAccount.TrustLevel trustLevel = post.getCreatorLevel();

        return (freshness * FRESHNESS_WEIGHT) +
                (commentCount * COMMENT_WEIGHT) +
                (helpfulSum * HELPFUL_WEIGHT) +
                (trustLevel.getWeight() * TRUST_WEIGHT);
    }

}
