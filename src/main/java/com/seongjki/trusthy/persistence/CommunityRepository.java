package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.Community;

import java.util.Optional;
import java.util.UUID;

public interface CommunityRepository {

    Community save(Community community);

    Optional<Community> find(UUID communityId);
}
