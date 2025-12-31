package com.seongjki.trusthy.service;

import com.seongjki.trusthy.domain.Community;
import com.seongjki.trusthy.domain.Member;
import com.seongjki.trusthy.domain.TrustAccount;
import com.seongjki.trusthy.dto.CreateCommunityResponse;
import com.seongjki.trusthy.persistence.CommunityRepository;
import com.seongjki.trusthy.persistence.MemberRepository;
import com.seongjki.trusthy.persistence.TrustAccountRepository;

public class CommunityService {

    private CommunityRepository communityRepository;

    private MemberRepository memberRepository;

    private TrustAccountRepository trustAccountRepository;

    public CommunityService(CommunityRepository communityRepository, MemberRepository memberRepository) {
        this.communityRepository = communityRepository;
        this.memberRepository = memberRepository;
    }

//    public CreateCommunityResponse createCommunity(String name, int capacity) {
//        Community community = new Community(1L, name, capacity);
//        TrustAccount trustAccount = new TrustAccount(1L);
//        Member member = new Member(1L, "nickname", new TrustAccount(1L));
//
//        communityRepository.save(community);
//        memberRepository.save(member);
//        trustAccountRepository.save(new TrustAccount(1L));
//    }

}
