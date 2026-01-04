package com.seongjki.trusthy.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class ExposureScoreCacluatorTest {

    Clock clock = Clock.fixed(
            LocalDateTime.of(2026, 1, 4, 17, 6, 0)
                    .toInstant(ZoneOffset.of("+9")),
            ZoneId.systemDefault()
    );

    @Test
    void caclulateTest() {
        //given
        Post lowest = new Post(UUID.randomUUID(), "n1", " c1", LocalDateTime.now(clock), UUID.randomUUID(),
                "c1", 10, 10, TrustAccount.TrustLevel.RESTRICTED);
        Post highest = new Post(UUID.randomUUID(), "n1", " c1", LocalDateTime.now(clock), UUID.randomUUID(),
                "c1", 10, 10, TrustAccount.TrustLevel.EX_HIGH);
        ExposureScoreCalculator calculator = new ExposureScoreCalculator(clock);

        //when
        double lowestScore = calculator.calculate(lowest);
        double highestScore = calculator.calculate(highest);

        //then
        assertThat(lowestScore).isLessThan(highestScore);
    }

    //TODO: Need More Test

}
