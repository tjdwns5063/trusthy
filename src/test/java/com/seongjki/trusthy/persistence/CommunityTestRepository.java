package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.Community;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CommunityTestRepository implements CommunityRepository {

    private final List<Community> communityList = new ArrayList<>();

    @Override
    public Community save(Community community) {
        communityList.add(community);
        return community;
    }

    @Override
    public Optional<Community> find(UUID communityId) {
        return communityList.stream().filter(community -> community.isSameId(communityId)).findFirst();
    }

}
