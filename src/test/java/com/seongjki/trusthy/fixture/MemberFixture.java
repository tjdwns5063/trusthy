package com.seongjki.trusthy.fixture;

import com.seongjki.trusthy.domain.Member;
import com.seongjki.trusthy.domain.TrustAccount;
import com.seongjki.trusthy.persistence.MemberRepository;
import java.util.UUID;

public class MemberFixture {

    public static Member savedMember(MemberRepository repo, String nickname, TrustAccount trustAccount) {
        Member m = new Member(UUID.randomUUID(), nickname, trustAccount);
        repo.save(m);
        return m;
    }

}
