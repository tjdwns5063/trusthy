package com.seongjki.trusthy.domain;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Getter
public class Post {

    private UUID id;

    private String name;

    private String content;

    private LocalDateTime createdAt;

    private UUID creatorId;

    private String creatorName;

    private int commentCount;

    private int helpfulSum;

    private TrustAccount.TrustLevel creatorLevel;

    public Post(UUID id, String name, String content, LocalDateTime createdAt,
                UUID creatorId, String creatorName, int commentCount, int helpfulSum,
                TrustAccount.TrustLevel creatorLevel) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.createdAt = createdAt;
        this.creatorId = creatorId;
        this.creatorName = creatorName;
        this.commentCount = commentCount;
        this.helpfulSum = helpfulSum;
        this.creatorLevel = creatorLevel;
    }

}
