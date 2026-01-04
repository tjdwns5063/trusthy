package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MemberTestRepository implements MemberRepository {

    private final List<Member> memberList = new ArrayList<>();

    @Override
    public Member save(Member member) {
        memberList.add(member);
        return member;
    }

    @Override
    public Optional<Member> find(UUID memberId) {
        return memberList.stream().filter(member -> member.isSameId(memberId)).findFirst();
    }
}
