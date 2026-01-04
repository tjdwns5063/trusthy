package com.seongjki.trusthy.domain;

import java.util.UUID;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class Member {

    private UUID id;

    private String nickname;

    private TrustAccount trustAccount;

    public Member(UUID id, String nickname, TrustAccount trustAccount) {
        if (nickname.isBlank()) {
            throw new IllegalArgumentException("Nickname must not be empty");
        }
        this.id = id;
        this.nickname = nickname;
        this.trustAccount = trustAccount;
    }

    public boolean hasSameNickname(Member member) {
        if (member == null) return false;

        return this.nickname.equals(member.nickname);
    }

    public boolean isSameId(UUID id) {
        return Objects.equals(this.id, id);
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
