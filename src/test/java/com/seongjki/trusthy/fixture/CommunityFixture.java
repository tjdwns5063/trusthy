package com.seongjki.trusthy.fixture;

import com.seongjki.trusthy.domain.Community;
import com.seongjki.trusthy.persistence.CommunityRepository;
import java.util.UUID;

public class CommunityFixture {

    public static Community createCommunity(CommunityRepository communityRepository, String name, int capacity) {
        return communityRepository.save(new Community(UUID.randomUUID(), name, capacity));
    }

}
