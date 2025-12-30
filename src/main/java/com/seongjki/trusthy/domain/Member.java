package com.seongjki.trusthy.domain;

import java.util.Objects;

public class Member {

    private long id;

    private String nickname;

    public Member(long id, String nickname) {
        if (nickname.isBlank()) {
            throw new IllegalArgumentException("Nickname must not be empty");
        }

        this.id = id;
        this.nickname = nickname;
    }

    public boolean hasSameNickname(Member member) {
        if (member == null) return false;

        return this.nickname.equals(member.nickname);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id && Objects.equals(nickname, member.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname);
    }

}
