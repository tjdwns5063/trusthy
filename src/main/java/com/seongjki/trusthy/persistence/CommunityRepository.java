package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.Community;

import java.util.Optional;

public interface CommunityRepository {

    Community save(Community community);

    Optional<Community> find(long communityId);
}
