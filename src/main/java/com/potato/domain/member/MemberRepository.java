package com.potato.domain.member;

import com.potato.domain.member.repository.MemberRepositoryCustom;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends ReactiveMongoRepository<Member, String>, MemberRepositoryCustom {

}
