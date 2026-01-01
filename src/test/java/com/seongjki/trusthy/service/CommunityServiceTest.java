package com.seongjki.trusthy.service;

import com.seongjki.trusthy.domain.*;
import com.seongjki.trusthy.dto.CommunityResponse;
import com.seongjki.trusthy.fixture.CommunityFixture;
import com.seongjki.trusthy.fixture.TrustAccountFixture;
import com.seongjki.trusthy.persistence.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CommunityServiceTest {

    private CommunityService communityService;

    private CommunityRepository communityRepository;

    private MemberRepository memberRepository;

    private TrustAccountRepository trustAccountRepository;

    private CommunityPolicy communityPolicy;

    @BeforeEach
    public void init() {
        communityRepository = new CommunityTestRepository();
        memberRepository = new MemberTestRepository();
        communityPolicy = new MemoryCommunityPolicy();
        trustAccountRepository = new TrustAccountTestRepository();
        communityService = new CommunityService(communityRepository, memberRepository, trustAccountRepository, communityPolicy);
    }

    @Test
    void createCommunitySuccess() {
        //given
        String name = "c1";
        int capacity = 100;
        String memberNickname = "m1";

        //when
        CommunityResponse res = communityService.createCommunity(name, capacity, memberNickname);

        //then
        assertThat(res).isEqualTo(new CommunityResponse(1L, "c1", 100, 1, Community.CommunityGrade.MEDIUM));
    }

    @Test
    void enterCommunitySuccess() {
        //given
        Community community = CommunityFixture.createCommunity(communityRepository, "c1", 100);

        //when
        CommunityResponse res = communityService.enterCommunity(community.getId(), "m1");

        //then
        assertThat(res).isEqualTo(new CommunityResponse(1L, "c1", 100, 1, Community.CommunityGrade.MEDIUM));
    }

    //TODO: 실패 테스트 케이스 작성

}
