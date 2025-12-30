package com.seongjki.trusthy.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CommunityTest {

    private Community community;

    @Test
    void createDefaultCommunity() {
        //given, when
        community = new Community(1L, "default_test", 100);

        //then
        assertThat(community).isEqualTo(new Community(1L, "default_test", 100, List.of(), Community.CommunityGrade.MEDIUM));
    }

    @Test
    void enterSuccess() {
        //given
        community = new Community(1L, "default_test", 100);
        Member member = new Member(1L, "mem1");

        //when
        community.enter(member);

        //then
        assertThat(community.contains(member)).isTrue();
    }

    @Test
    void enterFailBecauseExceedCapacity() {
        //given
        community = new Community(1L, "default_test", 5, List.of(
                new Member(1L, "m1"),
                new Member(2L, "m2"),
                new Member(3L, "m3"),
                new Member(4L, "m4"),
                new Member(5L, "m5")
        ), Community.CommunityGrade.MEDIUM);

        //when,then
        assertThatThrownBy(() -> community.enter(new Member(6L, "m6")))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Community capacity is full");
    }

    @Test
    void enterFailBecauseSameMember() {
        //given
        Member member = new Member(1L, "m1");
        community = new Community(1L, "default_test", 100, List.of(member), Community.CommunityGrade.MEDIUM);

        //when,then
        assertThatThrownBy(() -> community.enter(member))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Member already exists");
    }

    @Test
    void enterFailBecauseDuplicateNickname() {
        //given
        Member member = new Member(1L, "m1");
        community = new Community(1L, "default_test", 100, List.of(member), Community.CommunityGrade.MEDIUM);

        //when,then
        assertThatThrownBy(() -> community.enter(new Member(2L, "m1")))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Duplicate Member's nickname");
    }

    @Test
    void memberNull() {
        community = new Community(1L, "default_test", 100);

        assertThatThrownBy(() -> community.enter(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("member is null");
    }

}
