package com.seongjki.trusthy.persistence;

import com.seongjki.trusthy.domain.Member;

public interface MemberRepository {

    void save(Member member);

}
