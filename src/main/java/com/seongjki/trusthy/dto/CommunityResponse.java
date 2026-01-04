package com.seongjki.trusthy.dto;

import com.seongjki.trusthy.domain.Community;
import java.util.UUID;

public record CommunityResponse(
        UUID id,
        String name,
        int capacity,
        int size,
        Community.CommunityGrade grade
) {
}
