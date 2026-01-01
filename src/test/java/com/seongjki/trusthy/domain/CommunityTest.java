package com.seongjki.trusthy.domain;

import com.seongjki.trusthy.fixture.MemberFixture;
import java.util.UUID;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CommunityTest {

    private Community community;

    private CommunityPolicy policy = new MemoryCommunityPolicy();

    @Test
    void createFailNegativeCapacity() {
        assertThatThrownBy(() -> new Community(UUID.randomUUID(), "default_test", -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void enterSuccess() {
        //given
        community = new Community(UUID.randomUUID(),"default_test", 100);
        Member member = new Member(UUID.randomUUID(), "mem1", new TrustAccount(UUID.randomUUID()));

        //when
        community.enter(member, policy);

        //then
        assertThat(community.contains(member)).isTrue();
    }

    @Test
    void enterFailBecauseExceedCapacity() {
        //given
        community = new Community(UUID.randomUUID(),"default_test", 5);

        for (int i = 0; i < 5; ++i) {
            community.enter(new Member(UUID.randomUUID(), "mem" + i, new TrustAccount(UUID.randomUUID())), policy);
        }

        //when,then
        assertThatThrownBy(() -> community.enter(new Member(UUID.randomUUID(), "m6", new TrustAccount(UUID.randomUUID())), policy))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Community capacity is full");
    }

    @Test
    void enterFailBecauseSameMember() {
        //given
        Member member = new Member(UUID.randomUUID(), "m1", new TrustAccount(UUID.randomUUID()));
        community = new Community(UUID.randomUUID(),"default_test", 100);
        community.enter(member, policy);

        //when,then
        assertThatThrownBy(() -> community.enter(member, policy))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Member already exists");
    }

    //TODO: MemberRepository 구현 후 수정.
//    @Test
//    void enterFailBecauseDuplicateNickname() {
//        //given
//        Member member = new Member("m1", new TrustAccount());
//        community = new Community("default_test", 100);
//        community.enter(member, policy);
//
//        //when,then
//        assertThatThrownBy(() -> community.enter(new Member("m1", new TrustAccount()), policy))
//                .isInstanceOf(RuntimeException.class)
//                .hasMessage("Duplicate Member's nickname");
//    }

    @Test
    void memberNull() {
        community = new Community(UUID.randomUUID(),"default_test", 100);

        assertThatThrownBy(() -> community.enter(null, policy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("member is null");
    }

}
