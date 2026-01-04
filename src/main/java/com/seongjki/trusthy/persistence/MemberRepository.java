package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.Member;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> find(UUID memberId);
}
