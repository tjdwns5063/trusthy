package com.seongjki.trusthy.dto;

import com.seongjki.trusthy.domain.Community;

public record CommunityResponse(
        long id,
        String name,
        int capacity,
        int size,
        Community.CommunityGrade grade
) {
}
