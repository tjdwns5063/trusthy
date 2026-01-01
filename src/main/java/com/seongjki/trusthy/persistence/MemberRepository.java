package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.Member;

import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> find(long memberId);
}
