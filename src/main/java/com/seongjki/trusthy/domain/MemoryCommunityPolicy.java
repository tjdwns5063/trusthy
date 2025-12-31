package com.seongjki.trusthy.domain;

public class MemoryCommunityPolicy implements CommunityPolicy {

    @Override
    public void validateEnter(Community community, Member member) {
        if (member == null) {
            throw new IllegalArgumentException("member is null");
        }

        if (community.isExceedCapacity()) {
            throw new RuntimeException("Community capacity is full");
        }

        if (community.contains(member)) {
            throw new RuntimeException("Member already exists");
        }

        if (community.hasNickname(member)) {
            throw new RuntimeException("Duplicate Member's nickname");
        }

    }
}
