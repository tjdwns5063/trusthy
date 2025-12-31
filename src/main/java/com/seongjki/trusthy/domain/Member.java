package com.seongjki.trusthy.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class Member {

    private Long id;

    private String nickname;

    private TrustAccount trustAccount;

    public Member(String nickname, TrustAccount trustAccount) {
        if (nickname.isBlank()) {
            throw new IllegalArgumentException("Nickname must not be empty");
        }

        this.nickname = nickname;
        this.trustAccount = trustAccount;
    }

    public void assignId(long id) {
        if (this.id != null) {
            return;
        }
        this.id = id;
    }

    public boolean hasSameNickname(Member member) {
        if (member == null) return false;

        return this.nickname.equals(member.nickname);
    }

    public boolean isSameId(long id) {
        return this.id.equals(id);
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
