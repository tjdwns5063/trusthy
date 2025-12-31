package com.seongjki.trusthy.dto.mapper;

import com.seongjki.trusthy.domain.Community;
import com.seongjki.trusthy.dto.CommunityResponse;

public class CreateCommunityResponseMapper {

    public static CommunityResponse from(Community c) {
        return new CommunityResponse(
                c.getId(),
                c.getName(),
                c.getCapacity(),
                c.getSize(),
                c.getGrade()
        );
    }
}
