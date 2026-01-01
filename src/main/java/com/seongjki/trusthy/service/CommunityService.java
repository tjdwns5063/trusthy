package com.seongjki.trusthy.service;

import com.seongjki.trusthy.domain.Community;
import com.seongjki.trusthy.domain.CommunityPolicy;
import com.seongjki.trusthy.domain.Member;
import com.seongjki.trusthy.domain.TrustAccount;
import com.seongjki.trusthy.dto.CommunityResponse;
import com.seongjki.trusthy.dto.mapper.CommunityResponseMapper;
import com.seongjki.trusthy.persistence.CommunityRepository;
import com.seongjki.trusthy.persistence.MemberRepository;
import com.seongjki.trusthy.persistence.TrustAccountRepository;
import java.util.UUID;

public class CommunityService {

    private CommunityRepository communityRepository;

    private MemberRepository memberRepository;

    private TrustAccountRepository trustAccountRepository;

    private CommunityPolicy communityPolicy;

    public CommunityService(CommunityRepository communityRepository, MemberRepository memberRepository, TrustAccountRepository trustAccountRepository, CommunityPolicy communityPolicy) {
        this.communityRepository = communityRepository;
        this.memberRepository = memberRepository;
        this.trustAccountRepository = trustAccountRepository;
        this.communityPolicy = communityPolicy;
    }

    public CommunityResponse createCommunity(String name, int capacity, String nickname) {
        Community community = communityRepository.save(new Community(UUID.randomUUID(), name, capacity));
        TrustAccount trustAccount = trustAccountRepository.save(new TrustAccount(UUID.randomUUID()));
        Member member = memberRepository.save(new Member(nickname, trustAccount));

        community.enter(member, communityPolicy);

        return CommunityResponseMapper.from(community);
    }

    public CommunityResponse enterCommunity(UUID communityId, String nickname) {
        Community community = communityRepository.find(communityId).orElseThrow();
        TrustAccount trustAccount = trustAccountRepository.save(new TrustAccount(UUID.randomUUID()));
        Member member = memberRepository.save(new Member(nickname, trustAccount));

        community.enter(member, communityPolicy);

        return CommunityResponseMapper.from(community);
    }

    //TODO: 탈퇴 기능 구현

}
