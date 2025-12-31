package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.Community;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class CommunityTestRepository implements CommunityRepository {

    private final AtomicLong sequence = new AtomicLong();

    private List<Community> communityList = new ArrayList<>();

    @Override
    public Community save(Community community) {
        community.assignId(sequence.incrementAndGet());

        communityList.add(community);
        return community;
    }

    @Override
    public Optional<Community> find(long communityId) {
        return communityList.stream().filter(community -> community.isSameId(communityId)).findFirst();
    }

}
