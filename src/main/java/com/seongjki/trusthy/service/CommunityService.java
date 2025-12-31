package com.seongjki.trusthy.service;

import com.seongjki.trusthy.domain.Community;
import com.seongjki.trusthy.domain.CommunityPolicy;
import com.seongjki.trusthy.domain.Member;
import com.seongjki.trusthy.domain.TrustAccount;
import com.seongjki.trusthy.dto.CommunityResponse;
import com.seongjki.trusthy.dto.mapper.CreateCommunityResponseMapper;
import com.seongjki.trusthy.persistence.CommunityRepository;
import com.seongjki.trusthy.persistence.MemberRepository;
import com.seongjki.trusthy.persistence.TrustAccountRepository;

public class CommunityService {

    private CommunityRepository communityRepository;

    private MemberRepository memberRepository;

    private TrustAccountRepository trustAccountRepository;

    private CommunityPolicy communityPolicy;

    public CommunityService(CommunityRepository communityRepository, MemberRepository memberRepository, CommunityPolicy communityPolicy) {
        this.communityRepository = communityRepository;
        this.memberRepository = memberRepository;
        this.communityPolicy = communityPolicy;
    }

    public CommunityResponse createCommunity(String name, int capacity, String nickname) {
        Community community = new Community(name, capacity);
        TrustAccount trustAccount = new TrustAccount();
        Member member = new Member(nickname, trustAccount);

        trustAccountRepository.save(trustAccount);
        memberRepository.save(member);
        communityRepository.save(community);

        return CreateCommunityResponseMapper.from(community);
    }

    public CommunityResponse enterCommunity(long communityId, long memberId) {
        Community community = communityRepository.find(communityId).orElseThrow();
        Member member = memberRepository.find(memberId).orElseThrow();

        community.enter(member, communityPolicy);

        return CreateCommunityResponseMapper.from(community);
    }

    //TODO: 탈퇴 기능 구현

}
